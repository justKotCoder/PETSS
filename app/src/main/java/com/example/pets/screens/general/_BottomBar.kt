package com.example.pets.screens.general

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pets.R
import com.example.pets.navigation.NavRoute
import com.example.pets.screens.Registration_4
import com.example.pets.ui.theme.PetsTheme

@Composable
fun _BottomBar (navController: NavController){
    AnimatedVisibility(visible = true) {
        Box(Modifier.fillMaxWidth()) {
            BottomNavigation(
                Modifier
                    .height(60.dp)
                    .padding(top = 20.dp),
                backgroundColor = colorResource(id = R.color.bar)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_bar_menu),
                        contentDescription = "",
                        tint = Color.Gray
                    )
                    Icon(
                        painterResource(id = R.drawable.icon_bar_shop),
                        contentDescription = "",
                        tint = if(navController.currentBackStackEntry?.destination?.route== NavRoute.Shoping.route){ Color.White}else{Color.Gray},
                        modifier = Modifier.clickable {
                            navController.navigate(NavRoute.Shoping.route)

                        }

                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.icon_bar_market),
                        contentDescription = "",
                        tint = Color.Gray
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.icon_chat),
                        contentDescription = null,
                        tint=Color.Gray
                    )
                }
            }
            Button(
                onClick = { navController.navigate(NavRoute.Passport.route) },
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomCenter)
                    .offset(x = 0.dp, y = -7.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(
                        id = R.color.Activ_Button
                    ), contentColor = Color.Black
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.research_microscope_science_laboratory_lab_icon_233167),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun viewRegistration4(){

    PetsTheme {
        _BottomBar(navController = rememberNavController())
    }
}