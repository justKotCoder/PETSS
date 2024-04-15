package com.example.pets._class

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.pets.R


class Tovar {
    private var Image : Painter = NotImage1!!
    private var Price : Int = 500
    private var Old_Price: Int = 1350
    private var Name: String = "Quente"
    private var Ozenka: Double = 3.5
    private var Opicanie:String= "Ошейник кожаный для собак средних и крупных пород"

    fun SetImaige(painter: Painter){
        Image=painter
    }
    fun GetImaige():Painter{
        return Image
    }
    fun SetPrice(int: Int){
        Price =int
    }
    fun  GetPrice():Int{
        return Price
    }
    fun SetOld_Price(int: Int){
        Old_Price = int
    }
    fun GetOld_Price():Int{
        return  Old_Price
    }
    fun SetName(string: String){
        Name=string
    }
    fun GetName():String{
        return Name
    }
    fun SetOzenka(double: Double){
        Ozenka=double
    }
    fun GetOzenka():Double{
        return Ozenka
    }

    fun GetOpicanie():String{
        return Opicanie
    }
}