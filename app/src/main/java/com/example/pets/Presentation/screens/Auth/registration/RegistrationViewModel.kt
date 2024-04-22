package com.example.pets.Presentation.screens.Auth.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pets.Data.User
import com.example.pets.Domain.ResendOTPUseCase
import com.example.pets.Domain.SendOTPUseCase
import com.example.pets.Domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val sendOTPUseCase: SendOTPUseCase,
    private val resendOTPUseCase: ResendOTPUseCase,
    ): ViewModel() {

    private var user = User()

    fun getUser(): User {
        return user
    }

    fun setUser(newUser: User) {
        user = newUser
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            signUpUseCase.signUp(email, password)
        }
    }

    fun sendOTPUseCase(email: String, otp: String) {
        viewModelScope.launch {
            sendOTPUseCase.sendOTP(email, otp)
        }
    }

    fun resendOTPUseCase(email: String) {
        viewModelScope.launch {
            resendOTPUseCase.sendOTP(email)
        }
    }


}