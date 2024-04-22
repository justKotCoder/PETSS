package com.example.pets.Presentation.screens.Auth.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.Data.User
import com.example.pets.Presentation.navigation.NavRoute
import com.example.pets.R

import com.example.pets.Presentation.theme.PetsTheme


@Composable
    fun Registration(navController: NavController, viewModel: RegistrationViewModel) {
        var email by remember {
            mutableStateOf("")
        }

        var user by remember {
            mutableStateOf(viewModel.getUser())
        }

        Box(
            Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.Font_Main))
        ) {
            Column(
                Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 52.dp)
                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Регистрация",
                    fontSize = 28.sp,
                    color = colorResource(id = R.color.color_tema)
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, start = 16.dp)
                ) {
                    Text(
                        "Введите email",
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.BottomStart),
                        color = colorResource(id = R.color.color_text)
                    )
                }
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Поиск") },
                    shape = RoundedCornerShape(20.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(id = R.color.color_text),

                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = {
                        //viewModel.signUp(email, "12345678")
                        setUserData(viewModel, email)
                        navigateToRegistration2(navController)
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.icon),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                ) {
                    Text(text = "Дальше", fontSize = 22.sp, color = Color.White)
                }


            }

        }
    }


private fun setUserData(
    viewModel: RegistrationViewModel,
    email: String
) {
    viewModel.setUser(User(email = email))
}


private fun navigateToRegistration2(
    navController: NavController,
) {
    navController.navigate(NavRoute.Registration_2.route)
}


@Preview(showBackground = true)
    @Composable
    fun ViewRegistration() {
        PetsTheme {
            Registration(navController = rememberNavController(), viewModel = hiltViewModel())
        }
    }
