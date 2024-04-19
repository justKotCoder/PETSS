package com.example.pets.Domain

interface Registration {
    suspend fun signUp(email: String, password: String)

    suspend fun sendOTP(email: String, otp: String)

    suspend fun resendOTP(email: String)
}