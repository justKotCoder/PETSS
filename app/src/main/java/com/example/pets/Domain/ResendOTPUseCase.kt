package com.example.pets.Domain

import com.example.pets.Data.Auth.RegistrationImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResendOTPUseCase @Inject constructor(private val repository: RegistrationImpl) {
    suspend fun sendOTP(email: String) {
        repository.resendOTP(email)
    }
}