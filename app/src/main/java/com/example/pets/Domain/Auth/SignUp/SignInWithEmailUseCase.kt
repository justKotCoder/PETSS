package com.example.pets.Domain.Auth.SignUp

import com.example.pets.Data.Auth.SignUp.SignUpRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SignInWithEmailUseCase @Inject constructor(private val repository: SignUpRepositoryImpl) {
    suspend fun signIn(email: String, password: String) {
        repository.signInUserWithEmail(email, password)
    }
}