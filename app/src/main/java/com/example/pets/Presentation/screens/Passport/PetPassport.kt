package com.example.pets.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pets.Presentation.screens.General._BottomBar

@Preview
@Composable
fun PetPassportPreview() {
    PetPassport(
        navController = rememberNavController()
    )
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PetPassport(
    navController: NavController
) {
    Scaffold(
        bottomBar = {
            _BottomBar(
                navController = navController
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 0.dp,
                        end = 16.dp,
                        bottom = 40.dp
                    )
            ) {

            }
        }
    }
}

//@Composable
//fun Foto_Pets(navController: NavController){
//    var visibility by remember {
//        mutableStateOf(false)
//    }
//    Box(modifier = Modifier
//        .width(327.dp)
//        .height(257.dp)
//        .clip(RoundedCornerShape(18.dp))
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.kot),
//            contentDescription = "",
//            Modifier.fillMaxSize()
//        )
//        Column(
//            Modifier
//                .width(57.dp)
//                .align(alignment = Alignment.TopEnd)
//                .padding(top = 4.dp, end = 4.dp)
//        ) {
//            Spacer(modifier = Modifier.size(57.dp))
//            Box(
//                Modifier
//                    .width(46.dp)
//                    .height(140.dp)
//                    .offset(x = 0.dp, y = -30.dp)
//                    .clip(
//                        RoundedCornerShape(
//                            bottomEnd = 20.dp,
//                            bottomStart = 20.dp
//                        )
//                    )
//            ) {
//                Setting_(visibility, navController)
//            }
//        }
//        OutlinedButton(
//            onClick = { visibility = !visibility },
//            modifier = Modifier
//                .size(57.dp)
//                .align(Alignment.TopEnd)
//                .padding(top = 4.dp, end = 4.dp),
//            shape = CircleShape,
////            colors = ButtonDefaults.buttonColors(
////                backgroundColor = colorResource(
////                    id = R.color.Activ_Button
////                )),
//            contentPadding = PaddingValues(0.dp),
//        ) {
//            // Adding an Icon "Add" inside the Button
//            Icon(painter = painterResource(id = R.drawable.icon_profil) ,contentDescription = "content description",tint = Color.White)
//        }
//    }
//}
//
//
//@Composable
//fun Setting_(visibility:Boolean,navController: NavController){
//    Box(
//        Modifier
//            .width(46.dp)
//            .padding(start = 6.dp)
//
//            .clip(
//                RoundedCornerShape(
//                    bottomEnd = 20.dp,
//                    bottomStart = 20.dp
//                )
//            )
//    ){
//        AnimatedVisibility(
//            visible =visibility,
//            enter = slideInVertically(
//                // Start the slide from 40 (pixels) above where the content is supposed to go, to
//                // produce a parallax effect
//                initialOffsetY = { -40 }
//            ) + expandVertically(
//                expandFrom = Alignment.Top
//            ) + scaleIn(
//                // Animate scale from 0f to 1f using the top center as the pivot point.
//                transformOrigin = TransformOrigin(0.5f, 0f)
//            ) + fadeIn(initialAlpha = 0.3f),
//            exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)
//        ) {
//
//
//            Column(
//                Modifier
//                    .fillMaxSize()
//                    .align(Alignment.Center)
//                    .background(colorResource(id = R.color.Activ_Button)),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Icon(
//                    painter = painterResource(id = R.drawable.icon_edit),
//                    contentDescription = "",
//                    Modifier
//                        .padding(top = 35.dp)
//                        .clickable { navController.navigate(NavRoute.Passport_Edit.route) },
//                    tint = Color.White
//                )
//                Icon(
//                    painter = painterResource(id = R.drawable.icon_kalendar),
//                    contentDescription = "",
//                    Modifier
//                        .padding(top = 16.dp)
//                        .clickable { navController.navigate(NavRoute.Passport_Clendar.route) }
//                    ,
//                    tint = Color.White
//                )
//                Icon(
//                    painter = painterResource(id = R.drawable.icon_notes),
//                    contentDescription = "",
//                    Modifier
//                        .padding(top = 16.dp)
//                        .clickable { navController.navigate(NavRoute.Passport_Notes.route) }
//                    ,
//                    tint = Color.White
//                )
//            }
//        }
//
//    }
//}
//
//
//@Composable
//fun Card_Pets(){
//    var name by remember {
//        mutableStateOf("София")
//    }
//    var age by remember {
//        mutableStateOf("3 года")
//    }
//
//
//    Box(
//        Modifier
//            .width(257.dp)
//            .height(81.dp)
//            .offset(y = -29.dp)
//            .clip(RoundedCornerShape(18.dp))
//            .background(Color.White)
//
//
//
//    ){
//        Row(
//            Modifier
//                .fillMaxWidth()
//                .padding(top = 15.dp, start = 0.dp),horizontalArrangement = Arrangement.SpaceAround) {
//            Column {
//                Text(text = name, fontSize = 22.sp,color = colorResource(id = R.color.color_text),)
//                Text(text="Не уствновлено", fontSize = 14.sp,color = colorResource(id = R.color.color_text),)
//            }
//            Column(horizontalAlignment = Alignment.CenterHorizontally,) {
////                Icon(painter = painterResource(id = R.drawable.icon_female),contentDescription = null,
////                    Modifier
////                        .rotate(18f)
////                        .padding(top = 3.dp),
////                    tint = colorResource(id = R.color.color_text))
//                Text(text =age, fontSize = 14.sp, modifier = Modifier.padding(top=3.dp),color = colorResource(id = R.color.color_text) )
//            }
//        }
//    }
//}
//
//@Composable
//fun Haracterictika(){
//    var weight by remember(){
//        mutableStateOf("Короткошерстный")
//    }
//        Column(
//            Modifier
//                .width(257.dp)
//                .height(80.dp)
//                .clip(RoundedCornerShape(18.dp))
//                .background(Color.White)
//                .padding(top = 18.dp, bottom = 18.dp)
//                ,verticalArrangement = Arrangement.SpaceBetween) {
//            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Bottom){
//                Text(text="Вид шерсти", fontSize = 14.sp,color = colorResource(id = R.color.color_text))
//                Text(text = weight, fontSize = 14.sp,color = colorResource(id = R.color.color_text))
//            }
//            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceAround,verticalAlignment = Alignment.Bottom){
//                Text(text="Окрас", fontSize = 14.sp, color = colorResource(id = R.color.color_text))
//                Text(text = "Черный", fontSize = 14.sp,color = colorResource(id = R.color.color_text))
//            }
//
//        }
//
//}
//
//@Composable
//fun Chip(){
//    Row(
//        Modifier
//            .width(257.dp)
//            .padding(top = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
//        Column(Modifier.width(120.dp)){
//            Text(text = "Чип", fontSize = 12.sp,color = colorResource(id = R.color.color_text), modifier = Modifier.padding(start=12.dp))
//            Box(
//                Modifier
//                    .fillMaxWidth()
//                    .height(76.dp)
//                    .clip(RoundedCornerShape(18.dp))
//                    .background(Color.White)) {
//                Text(text = "QQwert00-22",color = colorResource(id = R.color.color_text), fontSize = 16.sp,textAlign = TextAlign.Center, modifier = Modifier
//                    .align(Alignment.Center)
//                    .width(55.dp))
//            }
//        }
//        Column(Modifier.width(120.dp)){
//            Text(text = "Расположение",color = colorResource(id = R.color.color_text), fontSize = 12.sp,modifier = Modifier.padding(start=12.dp))
//            Box(
//                Modifier
//                    .fillMaxWidth()
//                    .height(76.dp)
//                    .clip(RoundedCornerShape(18.dp))
//                    .background(Color.White)) {
//                Text(text = "Левое ухо",color = colorResource(id = R.color.color_text), fontSize = 16.sp, textAlign = TextAlign.Center ,modifier = Modifier
//                    .align(Alignment.Center)
//                    .width(55.dp))
//            }
//        }
//    }
//}
//
//@Composable
//fun Vaccination(){
//   Box(
//       Modifier
//           .padding(top = 16.dp)
//           .width(258.dp)
//           .height(80.dp)
//           .clip(RoundedCornerShape(18.dp))
//           .background(Color.White)){
//       Column(
//           Modifier
//               .fillMaxWidth()
//               .align(Alignment.Center)
//       ) {
//           Row(Modifier
//               .fillMaxWidth(),
//               horizontalArrangement = Arrangement.SpaceAround
//           ){
//               Text(text = "Дата вакцинации", fontSize = 10.sp,textAlign=TextAlign.Center, modifier = Modifier.width(77.dp))
//               Box(Modifier.height(24.dp)){
//                   Text(text = "Название", fontSize = 10.sp,textAlign=TextAlign.Center, modifier = Modifier
//                       .width(77.dp)
//                       .align(Alignment.Center))
//               }
//               Text(text = "Срок\nдействия", fontSize = 10.sp,textAlign=TextAlign.Center, modifier = Modifier.width(77.dp))
//           }
//           Row(
//               Modifier
//                   .fillMaxWidth()
//                   .padding(top = 10.dp),
//               horizontalArrangement = Arrangement.SpaceAround
//           ){
//               Text(text = "01-02-2023", fontSize = 10.sp, color = colorResource(id = R.color.color_text),textAlign=TextAlign.Center, modifier = Modifier.width(77.dp))
//               Text(text = "Рабифел", fontSize = 10.sp,color = colorResource(id = R.color.color_text),textAlign=TextAlign.Center, modifier = Modifier.width(77.dp))
//               Text(text = "01-02-2024", fontSize = 10.sp,color = colorResource(id = R.color.color_text),textAlign=TextAlign.Center, modifier = Modifier.width(77.dp))
//           }
//       }
//   }
//}
//
//
//@Composable
//fun Add_Button(){
//   Icon(painter = painterResource(id = R.drawable.icon_button_add), contentDescription ="null" ,
//       modifier = Modifier
//           .offset(x = 219.dp, y = 86.dp)
//           .clip(CircleShape)
//           .background(colorResource(id = R.color.Activ_Button))
//           .clickable { } )
//}
//
//Scaffold(bottomBar = {
//    _BottomBar(navController = navController)
//}) {
//    Surface(
//        Modifier
//            .fillMaxSize()
//        , color = colorResource(id = R.color.Font_Main)) {
//        Box(Modifier.fillMaxSize()){
//            Spacer(modifier = Modifier
//                .width(560.dp)
//                .height(638.dp)
//                .rotate(45f)
//                .offset(x = -165.dp, y = -50.dp)
//                .clip(RoundedCornerShape(135.dp))
//                .background(color = colorResource(id = R.color.fon))
//            )}
//        Column(Modifier.padding(
//            top = 37.dp, start = 16.dp, end = 16.dp
//        ),
//            horizontalAlignment = Alignment.CenterHorizontally) {
//            Foto_Pets(navController)
//            Card_Pets()
//            Haracterictika()
//            Chip()
//            Box(Modifier.width(258.dp)){
//                Vaccination()
//                Add_Button()
//            }
//        }
//    }
//
//}