package com.example.pets.Domain

import com.example.pets.Data.User

interface IRegistrationViewModel {

    fun getUser(): User

    fun setUser(newUser: User)

    fun signUpWithEmail(email: String, password: String)
    fun signUpWithEmailOnly(email: String)

    fun sendOTP(email: String, otp: String)

    fun resendOTP(email: String)




}