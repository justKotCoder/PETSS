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
            var a by remember {
                mutableStateOf(true)
            }
            PetsTheme {
                Scaffold() {
                    suspend fun doWork() {
                            delay(3000L)

                        a=true
                    }
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



