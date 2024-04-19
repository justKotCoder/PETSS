package com.example.pets.Domain

class SendOTPUseCase(private val repository: Registration) {
    suspend fun sendOTP(email: String, otp: String) {
        repository.sendOTP(email, otp)
    }
}