package com.example.pets.Domain.Auth.SignIn

import com.example.pets.Data.Auth.SignIn.SignInRepositoryImpl
import javax.inject.Inject

class SignInWithEmailUseCase @Inject constructor(private val repository: SignInRepositoryImpl) {

    suspend fun signIn(email: String, password: String) {
        repository.signIn(email, password)
    }


}