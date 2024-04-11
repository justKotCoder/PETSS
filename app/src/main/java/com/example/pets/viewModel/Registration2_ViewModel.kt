package com.example.pets.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class Registration2_ViewModel: ViewModel() {
    val Code :MutableStateFlow<String> = MutableStateFlow("")
    val Code_Prover :MutableStateFlow<String> = MutableStateFlow("000000")
    val Error :MutableStateFlow<Boolean> = MutableStateFlow(false)
}