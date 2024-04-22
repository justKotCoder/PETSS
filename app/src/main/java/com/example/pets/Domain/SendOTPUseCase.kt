package com.example.pets.Domain

import com.example.pets.Data.Auth.RegistrationImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SendOTPUseCase @Inject constructor(private val repository: RegistrationImpl) {
    suspend fun sendOTP(email: String, otp: String) {
        repository.verifyOTP(email, otp)
    }
}