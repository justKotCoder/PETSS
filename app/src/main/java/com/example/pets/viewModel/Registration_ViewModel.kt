package com.example.pets.viewModel

import androidx.lifecycle.ViewModel
import com.example.pets.pets
import kotlinx.coroutines.flow.MutableStateFlow

class Registration_ViewModel:ViewModel() {
    val Email: MutableStateFlow<String> = MutableStateFlow("")

}