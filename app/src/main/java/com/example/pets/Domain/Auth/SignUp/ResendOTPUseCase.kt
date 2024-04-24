package com.example.pets.Domain.Auth.SignUp

import com.example.pets.Data.Auth.SignUp.SignUpRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResendOTPUseCase @Inject constructor(private val repository: SignUpRepositoryImpl) {
    suspend fun sendOTP(email: String) {
        repository.resendOTP(email)
    }
}