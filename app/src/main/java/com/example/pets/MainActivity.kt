package com.example.pets


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.pets.navigation.PetsNavHost
import com.example.pets.ui.theme.PetsTheme
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
            PetsTheme {
                Scaffold() {
                        Surface(
                            modifier = Modifier.fillMaxSize()
                        ) {
                              PetsNavHost()
                        }
                }
            }
        }
    }


}



