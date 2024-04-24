package com.example.pets.Domain.Auth.SignUp

import com.example.pets.Data.Auth.SignUp.SignUpRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SendOTPUseCase @Inject constructor(private val repository: SignUpRepositoryImpl) {
    suspend fun sendOTP(email: String, otp: String) {
        repository.verifyOTP(email, otp)
    }
}