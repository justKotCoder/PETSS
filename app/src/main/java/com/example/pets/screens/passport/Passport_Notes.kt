package com.example.pets.screens

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pets.R
import com.example.pets.screens.general.PassportBar
import com.example.pets.screens.general._BottomBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Passport_Notes (navController: NavController) {
    Scaffold(bottomBar = {
        _BottomBar(navController = navController)
}) {
    Surface(Modifier.fillMaxSize(), color = colorResource(id = R.color.Font_Main)) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 40.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
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
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .fillMaxWidth()
                            .height(48.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Text(text = "Добавить событие")
                    }

                }
                PassportBar(navController)
            }
            ListNotes()
        }
    }
}
}

@Composable
fun notes(){
    Box(
        Modifier
            .width(156.dp)
            .height(149.dp)
            .padding(top = 15.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)){
    Column(Modifier.padding(8.dp))
    {
        Text(text = "Правила ухода за длинношерстной породой", fontSize = 14.sp, overflow = TextOverflow.Ellipsis, modifier = Modifier.height(20.dp))
        Text(text = "Когда человек, создает заметку, тут отображается текст в ней, я не буду придумывать что-то еще, так что просто заполняю пространство словами, Когда человек, создает заметку, тут отображается текст в ней, я не буду придумывать что-то еще, так что просто заполняю пространство словами", fontSize = 10.sp, overflow = TextOverflow.Ellipsis)
    }
    }
}

@Composable
fun RowNotes(i:Int){
    Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
        if(i<=5){
        notes()
        notes()
        }
        else{
            notes()
    }
    }
}

@Composable
fun ListNotes(){
    Column {
        for(i in 1..6){
        RowNotes(i)
        }
    }
}