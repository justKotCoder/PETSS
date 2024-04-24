package com.example.pets.Domain.Auth.SignUp

import com.example.pets.Data.Auth.SignUp.SignUpRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpWithEmailOnlyUseCase @Inject constructor(private val repository: SignUpRepositoryImpl) {
    suspend fun signUp(email: String) {
        repository.signUpWithEmailOnly(email)
    }
}