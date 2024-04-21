package com.example.pets.Presentation.screens.Auth.registration

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pets.Data.Auth.RegistrationImpl
import com.example.pets.Domain.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    var signUpUseCase: SignUpUseCase
): ViewModel() {


    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            Log.d("MyLog", "$signUpUseCase")
        }
    }


}