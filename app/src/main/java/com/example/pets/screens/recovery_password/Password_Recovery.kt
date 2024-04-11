package com.example.pets.screens

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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.navigation.NavRoute
import com.example.pets.ui.theme.PetsTheme
import com.example.pets.viewModel.Registration_ViewModel


@Composable
fun Password_Recovery(navController: NavController,viewModel: Registration_ViewModel){
    val email by viewModel.Email.collectAsState()


    Box(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.Font_Main))) {
        Column(
            Modifier
                .padding(start = 20.dp, end = 20.dp, top = 52.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Забыли пароль?", fontSize = 28.sp,color= colorResource(id = R.color.color_tema))
            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, start = 16.dp)) {
                Text("Введите email", fontSize = 14.sp, modifier = Modifier.align(Alignment.BottomStart), color = colorResource(
                    id = R.color.color_text
                )
                )
            }
            TextField(
                value = email,
                onValueChange ={viewModel.Email.value=it},
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
            Button(onClick = {

             navController.navigate(NavRoute.Password_Recovery_2.route)


            },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.icon), contentColor = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)) {
                Text(text = "Отправить письмо", fontSize = 22.sp, color = Color.White)
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun viewPassword(){
    PetsTheme {
        Password_Recovery(navController = rememberNavController(), Registration_ViewModel())
    }
}

