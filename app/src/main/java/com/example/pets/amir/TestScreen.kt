package com.example.pets.amir

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pets.amir._class1.Users
import com.example.pets.amir.navig.NavRoute1
import com.example.pets.navigation.NavRoute

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Test(navController: NavController){
    Scaffold(Modifier.fillMaxSize()) {
        Column() {
            Button(onClick = { navController.navigate(NavRoute1.Test2.route) }) {
                Text(text = "Переход на другую страницу")
            }
            LazyColumn(){
                items(Users!!.size){
                    Column() {
                        Text("Имя: ${Users!![it].GetName()}")
                        Text("Возраст: ${Users!![it].GetAge()}")
                        Text("Почтa: ${Users!![it].GetEmail()}")
                    }
                }
            }
        }

    }
}