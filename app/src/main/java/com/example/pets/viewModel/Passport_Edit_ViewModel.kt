package com.example.pets.viewModel

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.lifecycle.ViewModel
import com.example.pets.pets
import kotlinx.coroutines.flow.MutableStateFlow

class Passport_Edit_ViewModel :ViewModel() {
    val Nickname: MutableStateFlow<String> = MutableStateFlow(pets?.GetNick().toString())
    val Race:MutableStateFlow<String> = MutableStateFlow(pets?.GetRace().toString())
    val Pol:MutableStateFlow<String> = MutableStateFlow(pets?.GetPol().toString())
    val Age:MutableStateFlow<String> = MutableStateFlow(pets?.GetAge().toString())
    val Harackter: MutableStateFlow<ArrayList<String>> = MutableStateFlow(pets?.GetСharacteristic()!!)
    val OpicHaracket: MutableStateFlow<ArrayList<String>> = MutableStateFlow(pets?.GetСharacteristic_Opicanie()!!)
    val count: MutableStateFlow<Int> = MutableStateFlow(pets?.GetSizeList()!!)


    fun name(){
        pets?.SetNick(Nickname.toString())
    }


}