package com.example.pets.amir.navig

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pets._class.Tovar
import com.example.pets._class.tovar1
import com.example.pets.amir.Test
import com.example.pets.amir.Test2
import com.example.pets.pets
import com.example.pets.screens.*
import com.example.pets.screens.shop.Shoping_Tovar
import com.example.pets.viewModel.Registration2_ViewModel
import com.example.pets.viewModel.Registration_ViewModel
import com.example.pets.viewModel.Shoping_ViewModel


sealed class NavRoute1(val route:String){
    object Test:NavRoute1("test")
    object Test2:NavRoute1("test2")

}

@Composable
fun NavHost() {
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute1.Test.route ){
        composable(NavRoute1.Test.route){
            Authotization(navController = navController)
        }
        composable(NavRoute1.Test2.route){
            Test2()
        }


    }
}