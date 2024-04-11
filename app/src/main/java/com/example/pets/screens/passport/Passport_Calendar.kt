package com.example.pets.screens

import android.annotation.SuppressLint
import android.media.metrics.Event
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pets.R
import com.example.pets.screens.general.PassportBar
import com.example.pets.screens.general._BottomBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Calendar(navController: NavController){
    Scaffold(bottomBar = {
        _BottomBar(navController = navController)
    }) {
        Surface(Modifier.fillMaxSize(),color= colorResource(id = R.color.Font_Main)) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 40.dp)
                    .verticalScroll(
                        rememberScrollState()
                    )) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(Modifier.width(242.dp)) {
                        Text(
                            "Календарь",
                            fontSize = 22.sp,
                            color = colorResource(id = R.color.color_text),
                            modifier = Modifier.padding(top = 54.dp)
                        )
                        Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(16.dp))) {
                            Text(text = "Добавить событие")
                        }
                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color.White), horizontalAlignment = Alignment.CenterHorizontally){
                            Text(text = "Ближайшее событие", fontSize = 16.sp, modifier = Modifier.padding(top=7.dp))
                            Event(19.dp,23.dp)
                        }
                    }
                    PassportBar(navController)
                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                    ,horizontalAlignment = Alignment.End) {
                    Event(8.dp,16.dp)
                    Text(text = "Смотреть все", fontSize = 14.sp, modifier = Modifier.padding(top=4.dp,end=27.dp))
                }
                Text("История событий", fontSize = 22.sp, modifier = Modifier.padding(top=16.dp, bottom = 16.dp))
                Event2()
            }
        }
    }

}


@Composable
@Preview()
fun Event(top: Dp =0.dp,bottom:Dp=0.dp){

    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = top)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White), horizontalArrangement = Arrangement.SpaceAround) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Полный груминг", fontSize = 12.sp)
            Text(text = "Мастер Елена", modifier = Modifier.padding(top=3.dp))
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(102.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(18.dp)),
            contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "Софья", fontSize = 12.sp)
            }
        }
        Column() {
            Text(text = "24 февраля 2023", fontSize = 12.sp)
            Text("13:00 - 17:30", fontSize = 12.sp,modifier = Modifier.padding(top=8.dp))
            Text(text = "г.Москва Большая Семёновская 32/4", fontSize = 10.sp, modifier = Modifier
                .width(101.dp)
                .padding(top = 8.dp, bottom = bottom))
        }
    }
        

}

@Composable
@Preview()
fun Event2(){
    for(i in 1..7){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White), horizontalArrangement = Arrangement.SpaceAround) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Полный груминг", fontSize = 12.sp)
            Button(onClick = { /*TODO*/ },
                Modifier
                    .width(102.dp)
                    .height(24.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .padding(top = 4.dp),
                contentPadding = PaddingValues(0.dp)) {
                Text(text = "Софья", fontSize = 12.sp)
            }
        }
        Column() {
            Text(text = "24 февраля 2023", fontSize = 12.sp)
            Text("13:00 - 17:30", fontSize = 12.sp,modifier = Modifier.padding(top=8.dp,bottom = 12.dp))
        }
    }
    }
}