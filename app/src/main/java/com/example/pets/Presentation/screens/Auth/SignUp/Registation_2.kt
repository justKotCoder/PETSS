package com.example.pets.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.Data.User
import com.example.pets.Domain.Auth.SignUp.ISignUpViewModel
import com.example.pets.Presentation.navigation.NavRoute
import com.example.pets.Presentation.screens.Auth.SignUp.SignUpViewModel
import com.example.pets.R
import com.example.pets.Presentation.theme.PetsTheme

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun Registration_2(navController: NavController, viewModel: ISignUpViewModel = hiltViewModel<SignUpViewModel>()){

    val context = LocalContext.current

    var otp by remember {
        mutableStateOf("")
    }

    var otpError by remember {
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
            Text(text ="Регистрация", fontSize = 28.sp,color= colorResource(id = R.color.color_tema))
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp)) {
                Text("Введите код подтверждения", fontSize = 14.sp, modifier = Modifier.align(
                    Alignment.BottomStart),color= colorResource(
                    id = R.color.color_text
                )
                )
            }
            Box(){
                TextField(
                    value = otp,
                    onValueChange = { otp = it },
                    shape = RoundedCornerShape(20.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White

                    ),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                }
            }
            Text(text = "Неверный код, попробуйте еще раз",
                fontSize = 12.sp,
                color = if(!otpError){
                    Color.Transparent
                }
                else {
                    Color.Red
                },
                modifier = Modifier.padding(top=8.dp))
            Button(onClick = {
                try {
                    if(otp.isNotEmpty() && otp.length == 6) {
                        val userEmail = viewModel.getUser().email
                        viewModel.verifyOTP(userEmail!!, otp = otp)
                        navController.navigate(NavRoute.Registration_3.route)
                    }
                } catch (e: Exception) {
                    otpError = true
                    Toast.makeText(context, "Неверный код подтверждения!", Toast.LENGTH_SHORT).show()
                }

            },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.icon), contentColor = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)) {
                Text(text = "Дальше", fontSize = 22.sp,color= Color.White)
            }
            Text(text = stringResource(id = R.string.code_delivered),lineHeight = 16.sp, letterSpacing = 0.4.sp , fontSize = 12.sp, textAlign = TextAlign.Center ,modifier = Modifier.padding(top=8.dp,start=18.5.dp,end=18.5.dp),color= colorResource(
                id = R.color.color_text
            )
            )
            Text(text="Выслать еще раз", fontSize = 14.sp,modifier = Modifier
                .padding(top = 24.dp)
                .clickable {
                    val userEmail = viewModel.getUser().email!!
                    viewModel.resendOTP(userEmail)

                }, color = colorResource(id = R.color.color_text)
            )

        }

    }

}

//fake viewModel to use preview
class PreviewViewModel2() : ISignUpViewModel {
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
fun viewRegistration2(){
    PetsTheme {
        Registration_2(navController = rememberNavController(), PreviewViewModel2())
    }
}