package com.example.pets.Domain.Auth.SignUp

import com.example.pets.Data.User

interface ISignUpViewModel {

    fun getUser(): User

    fun setUser(newUser: User)

    fun signInWithEmail(email: String, password: String)

    fun signUpWithEmailOnly(email: String)

    fun verifyOTP(email: String, otp: String)

    fun resendOTP(email: String)




}