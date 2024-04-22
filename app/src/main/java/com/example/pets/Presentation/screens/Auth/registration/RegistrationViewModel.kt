package com.example.pets.Presentation.screens.Auth.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pets.Data.User
import com.example.pets.Domain.IRegistrationViewModel
import com.example.pets.Domain.ResendOTPUseCase
import com.example.pets.Domain.SendOTPUseCase
import com.example.pets.Domain.SignUpUseCase
import com.example.pets.Domain.SignUpWithEmailOnlyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val signUpWithEmailUseCase: SignUpUseCase,
    private val sendOTPUseCase: SendOTPUseCase,
    private val resendOTPUseCase: ResendOTPUseCase,
    private val signUpWithEmailOnlyUseCase: SignUpWithEmailOnlyUseCase,
    ): ViewModel() ,IRegistrationViewModel {

    private var user = User()

    override fun getUser(): User {
        return user
    }

    override fun setUser(newUser: User) {
        user = newUser
    }

    override fun signUpWithEmail(email: String, password: String) {
        viewModelScope.launch {
            signUpWithEmailUseCase.signUp(email, password)
        }
    }

    override fun signUpWithEmailOnly(email: String) {
        viewModelScope.launch {
            signUpWithEmailOnlyUseCase.signUp(email)
        }
    }

    override fun sendOTP(email: String, otp: String) {
        viewModelScope.launch {
            sendOTPUseCase.sendOTP(email, otp)
        }
    }

    override fun resendOTP(email: String) {
        viewModelScope.launch {
            resendOTPUseCase.sendOTP(email)
        }
    }


}