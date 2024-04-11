package com.example.pets._class

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.pets.R
var count2 =0
 var NotImage1 :Painter ?=null
 var tovar1:Tovar?=null
var List_Tovar:ArrayList<Tovar>?=null
@Composable
fun загрузка(){
    var NotImage = painterResource(id = R.drawable.not_foto)
    NotImage1=NotImage

    var a1 :ArrayList<Tovar> = arrayListOf()
    for(i in 0..4){
        var tovar = Tovar()
        tovar.SetName(i.toString())
        a1.add(tovar)
    }
    List_Tovar=a1
}