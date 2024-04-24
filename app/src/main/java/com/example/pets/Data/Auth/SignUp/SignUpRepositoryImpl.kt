package com.example.pets.Data.Auth.SignUp

import com.example.pets.Data.Server.Server
import com.example.pets.Domain.Auth.SignUp.SignUpRepository
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import javax.inject.Singleton



//Implementation of RegistrationRepository
@Singleton
object SignUpRepositoryImpl : SignUpRepository {

    private val auth = Server.server.auth

    //User registration request to server
    override suspend fun signInUserWithEmail(email: String, password: String) {

        //Updates user password to actual
        auth.updateUser {
            this.password = password
        }

        //Session sign in
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }

    }

    //User registration request to server
    override suspend fun signUpWithEmailOnly(email: String) {
        auth.signUpWith(OTP) {
            this.email = email
        }
    }

    //Send OTP code email request to server
    override suspend fun verifyOTP(email: String, otp: String) {
        auth.verifyEmailOtp(OtpType.Email.EMAIL, email, otp)
    }

    //Resend OTP code email request to server
    override suspend fun resendOTP(email: String) {
        auth.resendEmail(OtpType.Email.EMAIL, email)
    }



}