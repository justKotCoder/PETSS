package com.example.pets.screens


import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.Presentation.theme.PetsTheme
import com.example.pets.Presentation.navigation.NavRoute
import com.example.pets.Presentation.screens.General.PassportBar
import com.example.pets.Presentation.screens.General._BottomBar

@Preview(showBackground = true)
@Composable
fun pewStartScreen1(){
    PetsTheme {
        Passport_Edit(navController = rememberNavController())
    }
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
@Composable
fun Passport_Edit(navController: NavController){

    var visible by remember {
        mutableStateOf(false)
    }
    var Scroll by remember{
        mutableStateOf(true)
    }
    var text1 by remember{
        mutableStateOf("")
    }
    var text by remember {
        mutableStateOf("")
    }
    Scaffold(

            bottomBar = {
                _BottomBar(navController = navController)
            }
        
    

    ) {
        Surface(
            Modifier
                .fillMaxSize(), color = colorResource(id = R.color.Font_Main)
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(top = 0.dp, start = 15.dp, end = 15.dp, bottom = 40.dp)
                    .verticalScroll(
                        rememberScrollState(),
                        Scroll
                    )) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Профиль Питомца", fontSize = 22.sp, color = colorResource(id = R.color.color_text), modifier = Modifier.padding(top=54.dp))
                        Text(text = "Имя", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=24.dp))
                        Box() {
                            TextField(
                                value = "Name_Petz",
                                onValueChange ={"/*TODO*/ "},
                                shape = RoundedCornerShape(20.dp),
                                maxLines = 1,
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = Color.Transparent,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Transparent,
                                    backgroundColor = Color.White
                                ),
                                modifier = Modifier.height(42.dp)
                            )
                            Text(
                                text = "Name_Petz",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.color_text),
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .offset(x = 18.dp)
                            )
                        }
                        Text(text = "Изменить фотографию", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=2.dp))
                        Text(text = "Порода", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=10.dp))
                        Box() {
                        TextField(
                            value = "Race",
                            onValueChange = { "/*TODO*/ " },
                            shape = RoundedCornerShape(20.dp),
                            maxLines = 1,
                            colors = TextFieldDefaults.textFieldColors(
                                textColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent,
                                backgroundColor = Color.White
                            ),
                            modifier = Modifier.height(42.dp)
                            )
                            Text(
                                text = "Race",
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.color_text),
                                modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .offset(x = 18.dp)
                            )
                    }
                    }
                    PassportBar(navController)
                }
                Ctroka_3()
                Column(
                    Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth()
                        .height(56.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color.White)
                        .clickable {
                            visible = true
                            Scroll = false
                            text1 = ""
                            text = ""
                        }
                    ,
                ) {
                    Text(text ="Добавить параметр", fontSize = 16.sp , color = colorResource(id =R.color.color_text ), modifier = Modifier.padding(top=16.dp,start=24.dp))
                }
                Text(text = "Чип", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=16.dp))
                Box(
                    Modifier
                        .padding(top = 4.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White)){
                    Text(text = "QQWERT00-22", fontSize = 16.sp, color = colorResource(id = R.color.color_text), modifier = Modifier
                        .align(
                            Alignment.CenterStart
                        )
                        .padding(start = 24.dp))
                }
                Text(text = "Описание", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=16.dp))
                Box(
                    Modifier
                        .padding(top = 4.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White)){
                    Text(text = "Левое ухо", fontSize = 16.sp, color = colorResource(id = R.color.color_text), modifier = Modifier
                        .align(
                            Alignment.CenterStart
                        )
                        .padding(start = 24.dp))
                }
                Button(onClick = {

                    navController.navigate(NavRoute.SignIn.route)},
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Activ_Button)),
                    shape = CircleShape) {
                    Text(text = "Сохранить изменения", fontSize = 22.sp, color = Color.White)
                }



            }
            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(
                    initialAlpha = 0.4f
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 250)
                )
            ) {


                Box(
                    Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.font_edit))
                        .clickable {
                            Scroll = true
                            visible = false

                        }) {
                    Box(
                        Modifier
                            .width(328.dp)
                            .height(328.dp)
                            .align(Alignment.Center)
                    ) {
                        Column(
                            Modifier
                                .align(alignment = Alignment.Center)
                                .clip(RoundedCornerShape(18.dp))
                                .background(Color.White)
                        ) {

                            TextField(
                                value = text,
                                onValueChange = { text = it },
                                Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = colorResource(id = R.color.color_tema),

                                    backgroundColor = Color.White
                                ),
                                textStyle = TextStyle(fontSize = 22.sp),
                                placeholder = {
                                    Text(
                                        text = "Название",
                                        fontSize = 22.sp,
                                        color = colorResource(id = R.color.color_tema)
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            TextField(
                                value = text1,
                                onValueChange = {text1=it},
                                Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp),
                                colors = TextFieldDefaults.textFieldColors(
                                    textColor = colorResource(id = R.color.color_text),

                                    backgroundColor = Color.White
                                ),
                                textStyle = TextStyle(fontSize = 14.sp),
                                placeholder = {
                                    Text(
                                        text = "Описание",
                                        fontSize = 14.sp,
                                        color = colorResource(id = R.color.color_text)
                                    )
                                })
                        }
                    }
                }
            }

        }
    }
}

@Composable
fun Ctroka_3 (){
    var visibility by remember {
        mutableStateOf(false)
    }

    var button1 by remember {
        mutableStateOf(0)
    }
    Row(
        Modifier
            .padding(start = 0.dp)
            .fillMaxWidth()
        ,horizontalArrangement = Arrangement.SpaceBetween)
    {
        Column() {
            Text(text = "Возраст", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=14.dp))
            Box(Modifier.width(96.dp)){
                Box(Modifier.align(Alignment.Center)) {
                    this@Column.AnimatedVisibility(visible = visibility){
                        LazyColumn(
                            Modifier
                                .width(80.dp)
                                .height(140.dp)
                                .padding(top = 40.dp, start = 0.dp)
                                .clip(
                                    RoundedCornerShape(
                                        bottomStart = 20.dp,
                                        bottomEnd = 20.dp
                                    )
                                )
                                .background(Color.White)) {
                            items(50) {
                                if(it!=0){
                                    Box(Modifier.fillMaxWidth()){
                                        Text(
                                            text = it.toString(),
                                            modifier = Modifier
                                                .align(Alignment.Center)
                                                .padding(top = 6.dp)
                                                .clickable {
                                                    /*TODO*/
                                                })
                                    }
                                }}
                        }
                    }
                }
                Box(
                    Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .fillMaxWidth()
                        .height(42.dp)
                        .background(Color.White)
                )
                {
                    Icon(painter = painterResource(id = R.drawable.icon_v), contentDescription ="",
                        Modifier
                            .align(
                                Alignment.TopEnd
                            )
                            .padding(top = 18.dp, end = 24.dp)
                            .clickable {
                                visibility = !visibility
                                /*TODO*/
                            } )
                }
            }
        }
        Column() {
            Text(text = "Пол", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=14.dp))
            Box(
                Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(207.dp)
                    .height(42.dp)
                    .background(Color.White))
            {
                Row(Modifier.padding(2.dp),horizontalArrangement = Arrangement.SpaceAround){
                    Button(onClick = { "Женский"
                        button1=0},
                        Modifier
                            .width(104.dp)
                            .fillMaxHeight(),

                        colors = ButtonDefaults.buttonColors(if(button1==0){Color.Blue}else{Color.White}),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),) {
                        Text("Женский", fontSize = 16.sp, color = if(button1==0){Color.White}else{Color.Blue})
                    }
                    Button(onClick = { },
                        Modifier
                            .width(104.dp)
                            .fillMaxHeight(),
                        colors = ButtonDefaults.buttonColors(if(button1==1){Color.Blue}else{Color.White}),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),) {
                        Text("Мужской", fontSize = 16.sp, color = if(button1==1){Color.White}else{Color.Blue})
                    }
                }
            }
        }

    }


@Composable
fun Ctroka_4(){

    val openDialog = remember { mutableStateOf(false) }
    var deleit by remember {
        mutableStateOf(0)
    }


    Text(text = "Harackter!!.get(i)", fontSize = 12.sp, modifier = Modifier.padding(start = 25.dp,top=16.dp))
    TextField(
        value = "text2",
        onValueChange ={
                       " "
                       },
        shape = RoundedCornerShape(20.dp),
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.color_text),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            backgroundColor = Color.White
        ),trailingIcon = {
            Icon(painterResource(id = R.drawable.icon_delelit), contentDescription =null, modifier = Modifier.clickable {
                deleit=0
                openDialog.value = true


            })
        },
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .padding(top = 4.dp)

    )

    }
}






