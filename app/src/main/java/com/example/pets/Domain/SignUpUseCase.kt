package com.example.pets.Domain

class SignUpUseCase(private val repository: Registration) {
    suspend fun signUp(email: String, password: String) {
        repository.signUp(email, password)
    }
}