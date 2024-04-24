package com.example.pets.Domain.Auth.SignIn

interface SignInRepository {

    suspend fun signIn(email: String, password: String)

}