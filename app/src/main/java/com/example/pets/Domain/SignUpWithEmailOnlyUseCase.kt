package com.example.pets.Domain

import com.example.pets.Data.Auth.RegistrationImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignUpWithEmailOnlyUseCase @Inject constructor(private val repository: RegistrationImpl) {
    suspend fun signUp(email: String) {
        repository.signUpWithEmailOnly(email)
    }
}