package com.example.pets.screens.general

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pets.R
import com.example.pets.navigation.NavRoute

var enter:EnterTransition= fadeIn(
    initialAlpha = 0.4f
)
var exit :ExitTransition= fadeOut(

animationSpec = tween(durationMillis = 250)
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PassportBar(navController: NavController) {
    Box(
        Modifier.padding(top=44.dp)
    ){
        AnimatedVisibility(
            visible =true,
            enter = slideInVertically(
                // Start the slide from 40 (pixels) above where the content is supposed to go, to
                // produce a parallax effect
                initialOffsetY = { -40 }
            ) + expandVertically(
                expandFrom = Alignment.Top
            ) + scaleIn(
                // Animate scale from 0f to 1f using the top center as the pivot point.
                transformOrigin = TransformOrigin(0.5f, 0f)
            ) + fadeIn(initialAlpha = 0.3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut() + scaleOut(targetScale = 1.2f)
        ) {


            Column(
                Modifier
                    .padding(start = 4.dp, top = 35.dp)
                    .width(46.dp)
                    .height(134.dp)
                    .align(Alignment.Center)
                    .clip(
                        RoundedCornerShape(
                            bottomEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
                    .background(colorResource(id = R.color.Activ_Button))
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .padding(top = 22.dp)
                        .width(33.dp)
                        .height(33.dp)){
                    this@Column.AnimatedVisibility(if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Edit.route){true}else{false},enter= enter, exit= exit) {
                        Image(painter = painterResource(id = R.drawable.crycle), contentDescription ="", modifier = Modifier.align(
                            Alignment.Center))
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.icon_edit),
                        contentDescription = "",
                        Modifier
                            .align(Alignment.Center)
                            .clickable { navController.navigate(NavRoute.Passport_Edit.route) },
                        tint =if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Edit.route){
                            Color.Blue}else{
                            Color.White})
                }
                Box(
                    Modifier
                        .padding(top = 2.dp)
                        .width(33.dp)
                        .height(33.dp)){
                    this@Column.AnimatedVisibility(if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Clendar.route){true}else{false},enter= enter, exit= exit) {
                        Image(painter = painterResource(id = R.drawable.crycle), contentDescription ="", modifier = Modifier.align(
                            Alignment.Center))
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.icon_kalendar),
                        contentDescription = "",
                        Modifier
                            .align(Alignment.Center)
                            .clickable { navController.navigate(NavRoute.Passport_Clendar.route) },
                        tint =if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Clendar.route){
                            Color.Blue}else{
                            Color.White})
                }
                Box(
                    Modifier
                        .padding(top = 2.dp)
                        .width(33.dp)
                        .height(33.dp)){
                    this@Column.AnimatedVisibility(if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Notes.route){true}else{false},enter= enter, exit= exit) {
                        Image(painter = painterResource(id = R.drawable.crycle), contentDescription ="", modifier = Modifier.align(
                            Alignment.Center))
                    }

                    Icon(
                        painter = painterResource(id = R.drawable.icon_notes),
                        contentDescription = "",
                        Modifier
                            .align(Alignment.Center)
                            .clickable { navController.navigate(NavRoute.Passport_Notes.route) },
                        tint =if (navController.currentBackStackEntry?.destination?.route== NavRoute.Passport_Notes.route){
                            Color.Blue}else{
                            Color.White})
                }
            }
        }
        OutlinedButton(onClick = {},
            modifier= Modifier
                .size(57.dp)
                .align(Alignment.TopEnd)
                .padding(top = 4.dp, end = 4.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(
                    id = R.color.Activ_Button
                )
            ),
            contentPadding = PaddingValues(0.dp),
        ) {
            // Adding an Icon "Add" inside the Button
            Icon(painter = painterResource(id = R.drawable.icon_profil) ,contentDescription = "content description",tint = Color.White)
        }

    }
}
