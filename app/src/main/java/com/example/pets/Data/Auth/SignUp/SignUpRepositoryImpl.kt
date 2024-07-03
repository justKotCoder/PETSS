package com.example.pets.Data.Auth.SignUp

import com.example.pets.Data.Server.DatabaseConnectionManager
import com.example.pets.Domain.Auth.SignUp.SignUpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.mindrot.jbcrypt.BCrypt
import java.security.SecureRandom
import java.sql.Connection
import java.sql.Timestamp
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

@Singleton
class SignUpRepositoryImpl @Inject constructor(
    private val dbManager: DatabaseConnectionManager
) : SignUpRepository {

    override suspend fun signInUserWithEmail(email: String, password: String) {
        val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
        val query = "INSERT INTO users (email, password_hash, created_at, updated_at) VALUES (?, ?, ?, ?)"
        withContext(Dispatchers.IO) {
            val connection = dbManager.getConnection()
            connection.prepareStatement(query).use { statement ->
                val timestamp = Timestamp(Date().time)
                statement.setString(1, email)
                statement.setString(2, hashedPassword)
                statement.setTimestamp(3, timestamp)
                statement.setTimestamp(4, timestamp)
                statement.executeUpdate()
            }
            // Заглушка для высылания OTP кода по почте
        }
    }

    override suspend fun signUpWithEmailOnly(email: String) {
        val query = "INSERT INTO users (email, created_at, updated_at) VALUES (?, ?, ?)"
        withContext(Dispatchers.IO) {
            val connection = dbManager.getConnection()
            connection.prepareStatement(query).use { statement ->
                val timestamp = Timestamp(Date().time)
                statement.setString(1, email)
                statement.setTimestamp(2, timestamp)
                statement.setTimestamp(3, timestamp)
                statement.executeUpdate()
            }
            val otp = generateOtp()
            saveOtpToDatabase(email, otp, connection)
            sendOtpEmail(email, otp)
        }
    }

    override suspend fun verifyOTP(email: String, otp: String) {
        val query = "SELECT otp_code FROM otps WHERE email = ? AND otp_code = ?"
        withContext(Dispatchers.IO) {
            val connection = dbManager.getConnection()
            connection.prepareStatement(query).use { statement ->
                statement.setString(1, email)
                statement.setString(2, otp)
                val resultSet = statement.executeQuery()
                if (!resultSet.next()) {
                    throw IllegalArgumentException("Invalid OTP code")
                }
            }
        }
    }

    override suspend fun resendOTP(email: String) {
        val newOtp = generateOtp()
        val query = "UPDATE otps SET otp_code = ?, updated_at = ? WHERE email = ?"
        withContext(Dispatchers.IO) {
            val connection = dbManager.getConnection()
            connection.prepareStatement(query).use { statement ->
                statement.setString(1, newOtp)
                statement.setTimestamp(2, Timestamp(Date().time))
                statement.setString(3, email)
                statement.executeUpdate()
            }
            sendOtpEmail(email, newOtp)
        }
    }

    private suspend fun saveOtpToDatabase(email: String, otp: String, connection: Connection) {
        val query = "INSERT INTO otps (email, otp_code, created_at) VALUES (?, ?, ?) ON CONFLICT (email) DO UPDATE SET otp_code = ?, created_at = ?"
        withContext(Dispatchers.IO) {
            connection.prepareStatement(query).use { statement ->
                val timestamp = Timestamp(Date().time)
                statement.setString(1, email)
                statement.setString(2, otp)
                statement.setTimestamp(3, timestamp)
                statement.setString(4, otp)
                statement.setTimestamp(5, timestamp)
                statement.executeUpdate()
            }
        }
    }

    private fun generateOtp(): String {
        val random = SecureRandom()
        val otp = random.nextInt(1000000)
        return String.format("%06d", otp)
    }

    private fun sendOtpEmail(email: String, otp: String) {
        val from = "your-email@example.com"
        val host = "smtp.example.com"
        val properties = System.getProperties()
        properties.setProperty("mail.smtp.host", host)
        properties.setProperty("mail.smtp.port", "587")
        properties.setProperty("mail.smtp.auth", "true")
        properties.setProperty("mail.smtp.starttls.enable", "true")

        val session = Session.getInstance(properties, object : javax.mail.Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("your-email@example.com", "your-email-password")
            }
        })

        try {
            val message = MimeMessage(session)
            message.setFrom(InternetAddress(from))
            message.addRecipient(Message.RecipientType.TO, InternetAddress(email))
            message.subject = "Your OTP Code"
            message.setText("Your OTP code is: $otp")
            Transport.send(message)
            println("OTP email sent successfully...")
        } catch (mex: Exception) {
            mex.printStackTrace()
        }
    }
}
