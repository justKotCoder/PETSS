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
import com.example.pets.amir._class1.Petss
import com.example.pets.amir._class1.Users

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Test2(){
    Scaffold(Modifier.fillMaxSize()) {
        Column() {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Переход на другую странцу")
            }
            LazyColumn(){
                items(Petss!!.size){
                    Column() {
                        Text("Кличка: ${Petss!![it].GetNick()}")
                        Text("Возраст: ${Petss!![it].GetAge()}")
                        Text("Пол: ${Petss!![it].GetPol()}")
                    }
                }
            }
        }

    }
}