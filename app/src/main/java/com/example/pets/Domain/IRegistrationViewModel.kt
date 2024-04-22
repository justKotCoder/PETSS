package com.example.pets.Domain

import androidx.lifecycle.ViewModel
import com.example.pets.Data.User

interface IRegistrationViewModel {

    fun getUser(): User

    fun setUser(newUser: User)

    fun signUp(email: String, password: String)

    fun sendOTP(email: String, otp: String)

    fun resendOTP(email: String)




}