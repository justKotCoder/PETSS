package com.example.pets.Presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pets.Presentation.screens.Auth.SignIn.SignIn
import com.example.pets.Presentation.screens.Auth.SignIn.SignInViewModel
import com.example.pets.Presentation.screens.Auth.SignUp.Registration
import com.example.pets.Presentation.screens.Auth.SignUp.SignUpViewModel
import com.example.pets.Presentation.screens.Welcome.Main
import com.example.pets.screens.*
import com.example.pets.Presentation.screens.Passport.StartScreen
import com.example.pets.Presentation.screens.shop.Shoping_Tovar


sealed class NavRoute(val route:String){
    object Start: NavRoute("start_screen")
    object Registration: NavRoute("reg_screen")
    object Registration_2: NavRoute("reg_2_screen")
    object Registration_3: NavRoute("reg_3_screen")
    object Registration_4: NavRoute("reg_4_screen")
    object Password_Recovery: NavRoute("pass_screen")
    object Password_Recovery_2: NavRoute("pass_2_screen")
    object Password_Recovery_3: NavRoute("pass_3_screen")
    object Passport: NavRoute("passport_screen")
    object Passport_Edit: NavRoute("passport_edit_screen")
    object Passport_Notes: NavRoute("passport_notes")
    object Passport_Clendar: NavRoute("passport_clendar")
    object Shoping: NavRoute("shop_screen")
    object SignIn: NavRoute("Login")
    object Shoping_Tovar: NavRoute("shoping_tovar")
    object Start_Passpoer: NavRoute("start_passport")
}

@Composable
fun PetsNavHost() {
    val navController = rememberNavController()

    //SignUp viewModel
    val signUpViewModel: SignUpViewModel = hiltViewModel()

    //SignIn viewModel
    val signInViewModel: SignInViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = NavRoute.SignIn.route ){
        composable(NavRoute.Start.route){
            Main()
        }
        composable(NavRoute.Registration.route){
            Registration(navController = navController, viewModel = signUpViewModel)
        }
        composable(NavRoute.Registration_2.route){
            Registration_2(navController = navController, viewModel = signUpViewModel)
        }
        composable(NavRoute.Registration_3.route){
            Registration_3(navController = navController, viewModel = signUpViewModel)
        }
        composable(NavRoute.Registration_4.route){
            Registration_4(navController = navController, viewModel = signUpViewModel)
        }
        composable(NavRoute.SignIn.route){
            SignIn(navController = navController, viewModel = signInViewModel)
        }
        composable(NavRoute.Password_Recovery.route){
            Password_Recovery(navController = navController)
        }
        composable(NavRoute.Password_Recovery_2.route){
            Password_Recovery_2(navController = navController)
        }
        composable(NavRoute.Password_Recovery_3.route){
            Password_Recovery_3(navController = navController)
        }
        composable(NavRoute.Passport.route){
            Passport(navController = navController)
        }
        composable(NavRoute.Passport_Edit.route){
            Passport_Edit(navController = navController)
        }
        composable(NavRoute.Shoping.route){
            Shoping(navController = navController)
        }
        composable(NavRoute.Shoping_Tovar.route){
            Shoping_Tovar(navController = navController)
        }
        composable(NavRoute.Start_Passpoer.route){
            StartScreen(navController = navController)
        }

    }
}