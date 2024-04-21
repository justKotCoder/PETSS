package com.example.pets.Domain

import com.example.pets.Data.Auth.RegistrationImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpUseCase @Inject constructor(private val repository: RegistrationImpl) {
    suspend fun signUp(email: String, password: String) {
        repository.signUp(email, password)
    }
}