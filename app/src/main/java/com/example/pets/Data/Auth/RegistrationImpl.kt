package com.example.pets.Data.Auth

import com.example.pets.Data.Server.Server
import com.example.pets.Domain.Registration
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.providers.builtin.OTP
import javax.inject.Singleton


@Singleton
object RegistrationImpl : Registration {

    private val auth = Server.server.auth

    //User registration request to server
    override suspend fun signUpWithEmail(email: String, password: String) {
        auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }

    }

    override suspend fun signUpWithEmailOnly(email: String) {
        auth.signUpWith(OTP) {
            this.email = email
        }
    }

    //Send OTP code to user email request to server
    override suspend fun verifyOTP(email: String, otp: String) {
        auth.verifyEmailOtp(OtpType.Email.EMAIL, email, otp)
    }

    //Resend OTP code to user email request to server
    override suspend fun resendOTP(email: String) {
        auth.resendEmail(OtpType.Email.EMAIL, email)
    }



}