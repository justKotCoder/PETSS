package com.example.pets.Domain

class ResendOTP(private val repository: Registration) {
    suspend fun sendOTP(email: String) {
        repository.resendOTP(email)
    }
}