package com.example.pets.Presentation.screens.Auth.SignUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pets.Data.User
import com.example.pets.Domain.Auth.SignUp.ISignUpViewModel
import com.example.pets.Domain.Auth.SignUp.ResendOTPUseCase
import com.example.pets.Domain.Auth.SignUp.SendOTPUseCase
import com.example.pets.Domain.Auth.SignUp.SignInWithEmailUseCase
import com.example.pets.Domain.Auth.SignUp.SignUpWithEmailOnlyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpWithEmailUseCase: SignInWithEmailUseCase,
    private val verifyOTPUseCase: SendOTPUseCase,
    private val resendOTPUseCase: ResendOTPUseCase,
    private val signUpWithEmailOnlyUseCase: SignUpWithEmailOnlyUseCase,
    ): ViewModel(), ISignUpViewModel {

    private var user = User()

    override fun getUser(): User {
        return user
    }

    override fun setUser(newUser: User) {
        user = newUser
    }

    override fun signInWithEmail(email: String, password: String) {
        viewModelScope.launch {
            signUpWithEmailUseCase.signIn(email, password)
        }
    }

    override fun signUpWithEmailOnly(email: String) {
        viewModelScope.launch {
            signUpWithEmailOnlyUseCase.signUp(email)
        }
    }

    override fun verifyOTP(email: String, otp: String) {
        viewModelScope.launch {
            verifyOTPUseCase.sendOTP(email, otp)
        }
    }

    override fun resendOTP(email: String) {
        viewModelScope.launch {
            resendOTPUseCase.sendOTP(email)
        }
    }


}