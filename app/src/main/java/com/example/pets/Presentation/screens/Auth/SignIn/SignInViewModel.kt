package com.example.pets.Presentation.screens.Auth.SignIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pets.Domain.Auth.SignIn.ISignInViewModel
import com.example.pets.Domain.Auth.SignIn.SignInWithEmailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInWithEmailUseCase: SignInWithEmailUseCase
) : ViewModel(), ISignInViewModel {

    override fun signIn(email: String, password: String) {
        viewModelScope.launch {
            signInWithEmailUseCase.signIn(email, password)
        }
    }

}