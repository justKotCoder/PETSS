package com.example.pets.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.Presentation.navigation.NavRoute
import com.example.pets.Presentation.screens.General._BottomBar
import com.example.pets.Presentation.theme.PetsTheme
import kotlin.math.roundToInt


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Shoping(navController: NavController){
    val count:Double = 20.3
    var count1 = count
    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = { _BottomBar(navController) }
    ){
        Column() {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, top = 20.dp, end = 16.dp)
            ) {
                stroka_1()
                stroka_2()

                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(bottom = 30.dp)){
                    items(count = count1.roundToInt()){

                    }
                }
            }
        }
    }
}

@Composable
fun stroka_1(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        var text by remember {
            mutableStateOf("")
        }
        TextField(
            value = text,
            onValueChange ={text=it},
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Поиск") },
            shape = RoundedCornerShape(20.dp),
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.width(285.dp)
        )
        OutlinedButton(onClick = {},
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Font)),
            modifier= Modifier.size(50.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
        ) {
            // Adding an Icon "Add" inside the Button
            Icon(painter = painterResource(id = R.drawable.icon_profil) ,contentDescription = "content description", tint = Color.White)
        }
    }
}
@Composable
fun stroka_2(){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 17.dp), ) {
        Button(onClick = {},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Font), contentColor = Color.Black),
            contentPadding = PaddingValues(0.dp),
        ) {
            Row() {
                Icon(painter = painterResource(id = R.drawable.icon_filter) ,contentDescription = "content description",tint= Color.White
                    , modifier = Modifier.padding(start = 10.dp,top=4.dp))
                Text(text = "Фильтр", modifier = Modifier.padding(start = 9.dp, end = 12.dp,top=1.dp), color = Color.White )
            }
            //  Icon(Icons.Filled.Person ,contentDescription = "content description",tint= Color.Gray)
        }
        Button(onClick = {},
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.Font), contentColor = Color.Black),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .width(115.dp)
                .padding(start = 5.dp)
        ) {
            Text(text = "Сбросить", color = Color.White)
        }
    }
}

@Composable
fun _Tovar(navController:NavController){

    Column(
        Modifier
            .width(168.dp)
            .height(276.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Box(
            Modifier
                .height(156.dp)
                .clip(RoundedCornerShape(20.dp))) {
//            Image(painter = NotImage1!!,
//                contentDescription ="",
//                contentScale = ContentScale.Crop)
        }
        Row(Modifier.padding(top=3.dp, start = 5.dp), verticalAlignment = Alignment.Bottom) {
            Text(text = "price.toString()", fontSize = 22.sp)
            Text(text = "star_price.toString()", fontSize = 14.sp,textDecoration = TextDecoration.LineThrough, modifier = Modifier.padding(start = 8.dp), color = Color.Gray)
        }
        Text(text = "Name",
            Modifier
                .padding(start = 5.dp)
                .height(16.dp), color = colorResource(id =R.color.Font),fontSize=12.sp)
        Text(text = "Opicanie",
            Modifier
                .padding(start = 5.dp, end = 6.dp)
                .height(32.dp), fontSize =10.sp, lineHeight = 12.sp )
        Row(
            Modifier
                .padding(start = 5.dp, top = 4.dp, end = 6.dp)
                .height(15.dp)) {

            Icon(painter = painterResource(id = R.drawable.icon_cart) ,contentDescription = "content description",
                modifier = Modifier
                    .padding(start=45.dp)
                    .clickable {
                        navController.navigate(NavRoute.Shoping_Tovar.route)
                    })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun viewShop(){
    PetsTheme {
        Shoping(navController = rememberNavController())
    }
}