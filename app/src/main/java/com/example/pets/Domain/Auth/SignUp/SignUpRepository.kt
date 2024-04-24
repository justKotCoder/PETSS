package com.example.pets.Domain.Auth.SignUp

interface SignUpRepository {
    suspend fun signInUserWithEmail(email: String, password: String)

    suspend fun verifyOTP(email: String, otp: String)

    suspend fun resendOTP(email: String)

    suspend fun signUpWithEmailOnly(email: String)
}