package com.example.pets.amir

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.pets.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "InvalidColorHexValue")
@Preview
@Composable
fun adadd() {
    val context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }
    Scaffold(
        Modifier.background(color = colorResource(id = R.color.Font_Main))
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
                Modifier
                    .padding(start = 17.dp, end = 16.dp, top = 74.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.Gray, shape = RoundedCornerShape(20.dp))
                        .width(327.dp)
                        .height(257.dp)

                ) {

                }

            }
            Column(
                Modifier
                    .padding(start = 52.dp, end = 52.dp, top = 308.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                        .width(257.dp)
                        .height(84.dp)

                )
                Spacer(modifier = Modifier.size(16.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                        .width(257.dp)
                        .height(80.dp)


                )
                Spacer(modifier = Modifier.size(24.dp))
                Row(
                    Modifier
                        .fillMaxWidth()

                ) {
                    Box(
                        Modifier
                            .width(120.5.dp)
                            .height(76.dp)
                            .background(Color.White, shape = RoundedCornerShape(20.dp))
                            .weight(1f)
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Box(
                        Modifier

                            .width(120.5.dp)
                            .height(76.dp)
                            .background(Color.White, shape = RoundedCornerShape(20.dp))
                            .weight(1f)

                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(Color.White, shape = RoundedCornerShape(20.dp))
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, top = 15.dp, bottom = 22.dp, end = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Дата\nвакцинации",
                            color = colorResource(id = R.color.colorWindowPets),
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "Название",
                            color = colorResource(id = R.color.colorWindowPets),
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,

                            )
                        Text(
                            text = "Срок\nдействия",
                            color = colorResource(id = R.color.colorWindowPets),
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,

                            )
                    }
                }
            }


        }
    }
}


