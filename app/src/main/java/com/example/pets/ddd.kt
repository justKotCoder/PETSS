package com.example.pets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.pets._class.Pets
import com.example.pets.modifiers.DottedShape

var pets: Pets? =null

var modifier1:Modifier= Modifier
    .height(2.dp)
    .background(
        color = Color.Blue,
        shape = DottedShape(step = 13.dp)
    )



@Composable
fun a(){
    Column() {
        Spacer(
            modifier = Modifier
                .height(4.dp)
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.Pynctir),
                    shape = DottedShape(step = 8.dp)
                ))
    }
}
@Composable
fun b(){
    var color= colorResource(id = R.color.Pynctir)
   // a1=color
}