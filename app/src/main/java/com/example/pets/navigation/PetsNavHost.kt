package com.example.pets.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pets._class.tovar1
import com.example.pets.pets
import com.example.pets.screens.*
import com.example.pets.screens.passport.StartScreen
import com.example.pets.screens.registration.Registration
import com.example.pets.screens.shop.Shoping_Tovar
import com.example.pets.viewModel.Registration2_ViewModel
import com.example.pets.viewModel.Registration_ViewModel
import com.example.pets.viewModel.Shoping_ViewModel


sealed class NavRoute(val route:String){
    object Start:NavRoute("start_screen")
    object Registration:NavRoute("reg_screen")
    object Registration_2:NavRoute("reg_2_screen")
    object Registration_3:NavRoute("reg_3_screen")
    object Registration_4:NavRoute("reg_4_screen")
    object Password_Recovery:NavRoute("pass_screen")
    object Password_Recovery_2:NavRoute("pass_2_screen")
    object Password_Recovery_3:NavRoute("pass_3_screen")
    object Passport:NavRoute("passport_screen")
    object Passport_Edit:NavRoute("passport_edit_screen")
    object Passport_Notes:NavRoute("passport_notes")
    object Passport_Clendar:NavRoute("passport_clendar")
    object Shoping:NavRoute("shop_screen")
    object Authotization:NavRoute("authotiz_screen")
    object Shoping_Tovar:NavRoute("shoping_tovar")
    object Start_Passpoer:NavRoute("start_passport")
}

@Composable
fun PetsNavHost() {
    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Authotization.route ){
        composable(NavRoute.Start.route){
            Main()
        }
        composable(NavRoute.Registration.route){
            Registration(navController = navController)
        }
        composable(NavRoute.Registration_2.route){
            Registration_2(navController = navController, viewModel = Registration2_ViewModel())
        }
        composable(NavRoute.Registration_3.route){
            Registration_3(navController = navController)
        }
        composable(NavRoute.Registration_4.route){
           Registration_4(navController = navController)
        }
        composable(NavRoute.Authotization.route){
            Authotization(navController = navController)
        }
        composable(NavRoute.Password_Recovery.route){
            Password_Recovery(navController = navController, viewModel = Registration_ViewModel())
        }
        composable(NavRoute.Password_Recovery_2.route){
            Password_Recovery_2(navController = navController)
        }
        composable(NavRoute.Password_Recovery_3.route){
            Password_Recovery_3(navController = navController, viewModel = Registration_ViewModel())
        }
        composable(NavRoute.Passport.route){
            Passport(navController = navController)
        }
        composable(NavRoute.Passport_Edit.route){
            Passport_Edit(navController = navController, pets!!)
        }
        composable(NavRoute.Passport_Clendar.route){
            Calendar(navController = navController)
        }
        composable(NavRoute.Passport_Notes.route){
            Passport_Notes(navController = navController)
        }
        composable(NavRoute.Shoping.route){
            Shoping(navController = navController, viewModel = Shoping_ViewModel())
        }
        composable(NavRoute.Shoping_Tovar.route){
            Shoping_Tovar(navController = navController, tovar = tovar1!!)
        }
        composable(NavRoute.Start_Passpoer.route){
            StartScreen(navController = navController)
        }

    }
}