package com.example.pets


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets._class.*
import com.example.pets.amir.Test
import com.example.pets.amir._class1.User1
import com.example.pets.amir._class1.Users
import com.example.pets.amir._class1.загр
import com.example.pets.amir.navig.NavHost
import com.example.pets.navigation.NavRoute
import com.example.pets.navigation.PetsNavHost

import com.example.pets.screens.Main
import com.example.pets.screens.Registration_3
import com.example.pets.screens.shop.Shoping_Tovar
import com.example.pets.ui.theme.PetsTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            delay(50)
            window.setBackgroundDrawableResource(android.R.color.transparent)

        }
        super.onCreate(savedInstanceState)
        setContent {
            var a by remember {
                mutableStateOf(true)
            }
            PetsTheme {
                Scaffold() {
                    suspend fun doWork() {
                            delay(3000L)

                        a=true
                    }
                    b()
                        Surface(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            //if(a==true) {
                            //    var pets1= Pets()
                            //    pets=pets1
                            //    загрузка()
                            //    Log.d("kk", List_Tovar?.size.toString())
                            //    Calendar()
                            //    Passport_Notes()

                              PetsNavHost()

                            //}
                            //else{
                            //    Main()
                            //         GlobalScope.launch { doWork() }
                            //}
                            //загр()
                            // Log.d("tt", Users?.size.toString())
                            //Test()
                            //NavHost()

                        }
                }
            }
        }
    }


}



