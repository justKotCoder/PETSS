package com.example.pets.Data.Auth.SignIn

import com.example.pets.Data.Server.Server
import com.example.pets.Domain.Auth.SignIn.SignInRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import javax.inject.Singleton


@Singleton
object SignInRepositoryImpl : SignInRepository {

    val auth = Server.server.auth

    //User sign in
    override suspend fun signIn(email: String, password: String) {
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

}