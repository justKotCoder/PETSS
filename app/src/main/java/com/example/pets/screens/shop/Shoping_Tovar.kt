package com.example.pets.screens.shop

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pets.R
import com.example.pets._class.Tovar
import com.example.pets.screens.RowTovar
import com.example.pets.screens.general._BottomBar
import kotlin.math.roundToInt


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Shoping_Tovar(navController:NavController,tovar: Tovar){
    var fill by remember {
        mutableStateOf(false)
    }
    var modifier1 : Modifier by remember {
        mutableStateOf(
            Modifier
                .fillMaxWidth()
                .height(110.dp)
                .padding(top = 20.dp, start = 25.dp, end = 25.dp)
        )
    }
    var modifier2 : Modifier by remember {
        mutableStateOf(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(top = 20.dp, start = 25.dp, end = 25.dp))
    }
    Scaffold(
        Modifier.fillMaxSize(),
        bottomBar = { _BottomBar(navController) }
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 2.dp, bottom = 40.dp)
                .verticalScroll(
                    rememberScrollState(), true
                )
               ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Stroka1()
            Image(painter = painterResource(id = R.drawable.tovar0),
                contentDescription ="",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(338.dp)
                    .height(257.dp)
                    .padding(top = 27.dp)
                    .clip(
                        shape = RoundedCornerShape(18.dp)
                    )
            )
            Stroka2(tovar.GetOzenka())
            Stroka3(tovar.GetPrice())
            Stroka4(tovar.GetName(),tovar.GetOpicanie())
            Stroka5()
            Column(modifier = if(fill==false){ modifier1}else{modifier2}
                    ){
                for (i in 1..10){
                    Row(Modifier
                        .fillMaxWidth()
                        ,horizontalArrangement = Arrangement.SpaceBetween){
                        Text("Параметр", fontSize = 14.sp)
                        Text("--------------")
                        Text(text = "2.4 кг", fontSize = 14.sp)

                    }
                }
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp), horizontalAlignment = Alignment.End) {
                Text("Развернуть", fontSize = 12.sp, modifier = Modifier.clickable { fill =! fill })
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp), horizontalAlignment = Alignment.Start) {
                Text("Отзывы", fontSize = 16.sp, modifier = Modifier.padding(top=22.dp,bottom=4.dp))
            }
            Stroka6()
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 25.dp), horizontalAlignment = Alignment.End) {
                Text("Смотреть все", fontSize = 12.sp, modifier = Modifier.clickable { fill =! fill })
            }
            Text(text = "Добавить отзыв", fontSize = 16.sp,modifier=Modifier.padding(top=16.dp))
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun Stroka1(){
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
fun Stroka2(Ozenka:Double){
    var Ozenka=Ozenka
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 11.dp)
            .height(25.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    verticalAlignment = Alignment.CenterVertically) {
        Row(
            Modifier
                .fillMaxHeight()
                .width(130.dp), horizontalArrangement = Arrangement.SpaceEvenly){
            for(i in 1..5){
                if(i<=Ozenka){
                    Icon(painter = painterResource(id = R.drawable.ozenka), tint = Color.Yellow ,contentDescription = "content description", modifier = Modifier
                        .width(23.dp)
                        .height(23.dp))
                }
                else{
                    Icon(painter = painterResource(id = R.drawable.ozenka),contentDescription = "content description",modifier = Modifier
                        .width(23.dp)
                        .height(23.dp) )
                }
            }
        }

        Row(
            Modifier
                .fillMaxHeight()
                .width(130.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            for(i in 1..4){
                Icon(painter = painterResource(id = R.drawable.icon_color), contentDescription ="", tint = Color.Red )
            }
            Icon(painter = painterResource(id = R.drawable.icon_ctrelka_nabravo), contentDescription = "")
        }


    }
}
@Composable
fun Stroka3(Price:Int,star_price:Int=800){
    var price= Price
    var star_price=800
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 25.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(text = price.toString()+" р", fontSize = 32.sp)
        Text(text = star_price.toString()+" р", fontSize = 22.sp,textDecoration = TextDecoration.LineThrough, modifier = Modifier.padding(start = 8.dp), color = Color.Gray)
    }
}
@Composable
fun Stroka4(Name_Tovara:String="Ошейник из натуральной кожи",Opicanie:String){
    var Name_Tovara= Name_Tovara
    var Marker="Ciprino Dorato"
    var Opicanie=Opicanie
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, end = 25.dp)) {
        Text(text = Name_Tovara, fontSize = 16.sp,)
        Text(text = Marker, fontSize = 14.sp, modifier = Modifier.padding(top=7.dp))
        Text(text = Opicanie, fontSize = 12.sp,overflow = TextOverflow.Ellipsis, modifier = Modifier
            .padding(top = 7.dp)
            .height(69.dp))
    }
}
@Composable
fun Stroka5(){
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .width(227.dp)
            .height(50.dp)
            .clip(
                RoundedCornerShape(18.dp)
            )) {
            Text(text="В корзину", fontSize = 22.sp)
        }
        Button(onClick = { /*TODO*/ }, modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(18.dp))
        ) {
            Icon(painter = painterResource(id = R.drawable.icon_love), contentDescription ="" )
        }
    }

}
@Composable
fun Stroka6(){
    Column(
        Modifier
            .width(303.dp)

            ){
        for(i in 1..3){
            Box(
                Modifier
                    .padding(bottom = 4.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(Color.Gray)){
                Comment()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Comment(){
    Row(
        Modifier

            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 9.dp, top = 9.dp, end = 9.dp, bottom = 9.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
        Column(Modifier.fillMaxWidth(0.4f)) {
            Row(
                Modifier
                    .height(16.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Оксана", fontSize = 12.sp)
                Row(
                    Modifier
                        .fillMaxHeight()
                        .width(55.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                    for(i in 1..5){
                        if(i<=2.5){
                            Icon(painter = painterResource(id = R.drawable.ozenka), tint = Color.Yellow ,contentDescription = "content description", modifier = Modifier
                                .width(10.dp)
                                .height(10.dp))
                        }
                        else{
                            Icon(painter = painterResource(id = R.drawable.ozenka),contentDescription = "content description",modifier = Modifier
                                .width(10.dp)
                                .height(10.dp) )
                        }
                    }
                }
            }
            Row(
                Modifier
                    .padding(top = 3.dp)
                    .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround){
                Image(painter = painterResource(id = R.drawable.tovar0), contentDescription ="", modifier = Modifier
                    .width(49.dp)
                    .height(49.dp)
                    .clip(RoundedCornerShape(11.dp)))
                Image(painter = painterResource(id = R.drawable.tovar0), contentDescription ="", modifier = Modifier
                    .width(49.dp)
                    .height(49.dp)
                    .clip(RoundedCornerShape(11.dp))
                )
            }
        }
        Text(text = "Брали для щенка. Искали что-то на время. За свои деньги хорошая вещь, но после поменяем. Быстро протерлась.", fontSize = 12.sp, modifier = Modifier
            .width(180.dp)
            .height(71.dp))
    }
}