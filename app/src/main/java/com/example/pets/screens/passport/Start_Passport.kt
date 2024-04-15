package com.example.pets.screens.passport

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.navigation.NavRoute
import com.example.pets.navigation.PetsNavHost
import com.example.pets.screens.general._BottomBar
import com.example.pets.ui.theme.Blauw200
import com.example.pets.ui.theme.Blue200
import com.example.pets.ui.theme.PetsTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartScreen(navController: NavController) {
    Scaffold(
        Modifier.background(color = colorResource(id = R.color.Font_Main))
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            Box(
                Modifier
                    .fillMaxSize()
                    .background(color = colorResource(id = R.color.Font_Main))
            ) {
                Spacer(
                    modifier = Modifier
                        .width(560.dp)
                        .height(638.dp)
                        .rotate(45f)
                        .offset(x = -165.dp, y = -50.dp)
                        .clip(RoundedCornerShape(135.dp))
                        .background(color = colorResource(id = R.color.Font))
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.haski2),
                            contentDescription = "Хаски",
                            modifier = Modifier.fillMaxSize()
                        )


                    }


                    Text(
                        text = "У вас ещё нет питомцев !",
                        modifier = Modifier.fillMaxWidth()
                            .width(256.dp)
                            .height(28.dp),
                        color = Blue200,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center
                    )





                    Button(
                        onClick = { NavRoute.Passport },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Blauw200),
                        modifier = Modifier
                            .width(256.dp)
                            .padding(10.dp)
                            .height(49.dp)

                    ) {
                        Text(
                            text = "Добавить",
                            color = Color.White
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun viewRegistration5(){

    PetsTheme {
        StartScreen(navController = rememberNavController())
    }
}



//            Column(
//                Modifier
//                    .padding(start = 17.dp, end = 16.dp, top = 74.dp)
//                    .fillMaxWidth()
//            ) {
//
//                    Image(
//                        imageVector = ImageVector.vectorResource(R.drawable.haski2),
//                        contentDescription = "Хаски"
//                    )








