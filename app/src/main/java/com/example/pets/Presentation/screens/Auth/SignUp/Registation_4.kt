package com.example.pets.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.Data.User
import com.example.pets.Domain.Auth.SignUp.ISignUpViewModel
import com.example.pets.R
import com.example.pets.Presentation.navigation.NavRoute
import com.example.pets.Presentation.screens.Auth.SignUp.SignUpViewModel
import com.example.pets.Presentation.theme.PetsTheme
import kotlinx.coroutines.runBlocking

@Composable
fun Registration_4(navController: NavController, viewModel: ISignUpViewModel = hiltViewModel<SignUpViewModel>()){

    val context = LocalContext.current

    var password by remember {
        mutableStateOf("")
    }
    var password_copy by remember {
        mutableStateOf("")
    }
    
    var error by remember {
        mutableStateOf(false)
    }

    var passwordVisibility by remember {
        mutableStateOf(false)
    }


    Box(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Font_Main))) {
        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp, top = 52.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Регистрация", fontSize = 28.sp, color = colorResource(id = R.color.color_tema))
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp)) {
                Text("Придумайте пароль", fontSize = 14.sp, modifier = Modifier.align(Alignment.BottomStart),color= colorResource(
                    id = R.color.color_text
                )
                )
            }
            TextField(
                value = password,
                onValueChange = { password = it },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Поиск") },
                trailingIcon = { if (!passwordVisibility) {
                    Icon(painterResource(
                        id = R.drawable.visibility_off),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passwordVisibility = true
                        })
                }
                else {
                    Icon(painterResource(
                        id = R.drawable.visibility_on),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passwordVisibility = false
                        })
                }}
                ,
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
                visualTransformation = if( passwordVisibility == false){
                    PasswordVisualTransformation()
                } else {
                    VisualTransformation.None
                }
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp)) {
                Text("Повторите пароль", fontSize = 14.sp, modifier = Modifier.align(Alignment.BottomStart), color = colorResource(
                    id = R.color.color_text
                )
                )
            }
            TextField(
                value = password_copy,
                onValueChange = { password_copy = it },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Поиск") },
                trailingIcon = {
                    if( !passwordVisibility ) {
                        Icon(painterResource(id = R.drawable.visibility_off), contentDescription = null, modifier = Modifier.clickable { passwordVisibility = true })
                    }
                    else {
                            Icon(painterResource(id = R.drawable.visibility_on), contentDescription = null, modifier = Modifier.clickable { passwordVisibility = false })
                        }
                    },
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
                visualTransformation = if(!passwordVisibility) {
                    PasswordVisualTransformation()
                }else{
                    VisualTransformation.None}
            )
            Text(text = "Пароли не совпадают", fontSize = 12.sp, color = if(error) {
                Color.Red
            }
            else {
                Color.Transparent
            },
                modifier = Modifier.padding(top=8.dp))
            Button(onClick = {
                if(password == password_copy && password.length >= 8){
                    runBlocking {
                        val user = viewModel.getUser()
                        val newUser = user.copy(password = password)

                        viewModel.setUser(newUser)

                        val userEmail = viewModel.getUser().email
                        val userPassword = viewModel.getUser().password

                        viewModel.signInWithEmail(userEmail!!, userPassword!!)
                        navController.run { navigate(NavRoute.Start_Passpoer.route) {
                            popUpTo(0)
                            }
                        }
                    }
                }
                else {
                    error = true
                }

            },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.icon), contentColor = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)) {
                Text(text = "Дальше", fontSize = 22.sp,color= Color.White)
            }


        }

    }
}
//fake viewModel to use Preview
class PreviewViewModel4() : ISignUpViewModel {
    override fun getUser(): User {
        return User()
    }

    override fun setUser(newUser: User) {
        //TODO("Not yet implemented")
    }

    override fun signInWithEmail(email: String, password: String) {
        //TODO("Not yet implemented")
    }

    override fun signUpWithEmailOnly(email: String) {
        //TODO("Not yet implemented")
    }

    override fun verifyOTP(email: String, otp: String) {
        //TODO("Not yet implemented")
    }

    override fun resendOTP(email: String) {
        //ODO("Not yet implemented")
    }

}

@Preview(showBackground = true)
@Composable
fun ViewRegistration4(){

    PetsTheme {
        Registration_4(navController = rememberNavController(), viewModel = PreviewViewModel4())
    }
}