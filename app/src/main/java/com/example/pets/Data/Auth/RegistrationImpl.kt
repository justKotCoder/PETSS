package com.example.pets.Data.Auth

import com.example.pets.Data.Server
import com.example.pets.Domain.Registration
import io.github.jan.supabase.gotrue.OtpType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

object  RegistrationImpl : Registration {

    private val auth = Server.server.auth

    //Registration request to server
    override suspend fun signUp(email: String, password: String) {
        auth.signUpWith(Email) {
            this.email = email
            this.password = email
        }

    }

    //Send OTP code to email request to server
    override suspend fun sendOTP(email: String, otp: String) {
        auth.verifyEmailOtp(OtpType.Email.EMAIL, email, otp)
    }


    override suspend fun resendOTP(email: String) {
        auth.resendEmail(OtpType.Email.EMAIL, email)
    }
}