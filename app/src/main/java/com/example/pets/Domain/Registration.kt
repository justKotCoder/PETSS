package com.example.pets.Domain

interface Registration {
    suspend fun signUpWithEmail(email: String, password: String)

    suspend fun verifyOTP(email: String, otp: String)

    suspend fun resendOTP(email: String)

    suspend fun signUpWithEmailOnly(email: String)
}