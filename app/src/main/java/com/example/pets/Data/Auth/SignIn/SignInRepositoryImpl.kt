package com.example.pets.Data.Auth.SignIn

import com.example.pets.Data.Server.DatabaseConnectionManager
import com.example.pets.Domain.Auth.SignIn.SignInRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.mindrot.jbcrypt.BCrypt
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignInRepositoryImpl @Inject constructor(
    private val dbManager: DatabaseConnectionManager
) : SignInRepository {

    override suspend fun signIn(email: String, password: String) {
        val query = "SELECT password_hash FROM users WHERE email = ?"
        withContext(Dispatchers.IO) {
            val connection = dbManager.getConnection()
            connection.prepareStatement(query).use { statement ->
                statement.setString(1, email)
                statement.executeQuery().use { resultSet ->
                    if (resultSet.next()) {
                        val storedHash = resultSet.getString("password_hash")
                        if (!BCrypt.checkpw(password, storedHash)) {
                            throw IllegalArgumentException("Invalid email or password")
                        }
                    } else {
                        throw IllegalArgumentException("Invalid email or password")
                    }
                }
            }
        }
    }
}
