package com.example.pets.Presentation.screens.Auth.SignIn

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.Domain.Auth.SignIn.ISignInViewModel
import com.example.pets.R


import com.example.pets.Presentation.navigation.NavRoute
//import com.example.pets.pets

import com.example.pets.Presentation.theme.PetsTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignIn(navController: NavController, viewModel: ISignInViewModel = hiltViewModel<SignInViewModel>()) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var visibility by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()




    val context = LocalContext.current

    Scaffold() {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.Font_Main))
        ) {
            Column(
                Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 52.dp)
                    .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
               Text(
                   text = "Добро Пожаловать",
                   fontSize = 28.sp,
                   color = colorResource(id = R.color.color_tema)
               )

                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, start = 16.dp)
                ) {
                    EnterEmailText()
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
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 16.dp)
                ) {
                    Text(
                        "Введите пароль",
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.BottomStart),
                        color = colorResource(
                            id = R.color.color_text
                        )
                    )
                }
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Поиск") },
                    shape = RoundedCornerShape(20.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = colorResource(id = R.color.color_text),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 9.dp)
                ) {
                    Text(
                        "Забыли пароль?", fontSize = 14.sp,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clickable { navController.navigate(NavRoute.Password_Recovery.route) },
                        color = colorResource(id = R.color.color_text)
                    )
                }

                Button(
                    onClick = {
                        viewModel.signIn(email, password)

                    },

                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(id = R.color.icon),
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 54.dp)
                ) {
                    Text(text = "Войти", fontSize = 22.sp, color = Color.White)
                }
                Text(
                    text = "Регистрация",
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable { navController.navigate(NavRoute.Registration.route) },
                    color = colorResource(id = R.color.color_1)

                )

            }

        }

    }

}


//fake ViewModel to use preview
class ViewModelPreview : ISignInViewModel {
    override fun signIn(email: String, password: String) {
        TODO("Not yet implemented")
    }

}

//Error if invalid password/email
fun showError(context: Context) {
    Toast
        .makeText(context, "Неверный логин либо пароль!", Toast.LENGTH_SHORT)
        .show()
}


@Preview(showBackground = true)
@Composable
fun PewStartScreen() {
    PetsTheme {
        SignIn(navController = rememberNavController(), viewModel = ViewModelPreview())
    }
}

@Composable
fun EnterEmailText() {
    Text(
        text = "Введите почту",
        fontSize = 14.sp,
        color = colorResource(id = R.color.color_tema)
    )
}