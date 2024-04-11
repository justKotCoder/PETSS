package com.example.pets.amir._class1

class Pets1 {
    private var Nickname :String="Валера"
    private var Race: String="Кошка английская"
    private var Age:String="5"
    private var Pol:String="Мужской"
    private var Chip_Number:String="QQWERT00-22"
    private var Description:String="Левое ухо"
    private var Сharacteristic:ArrayList<String> = arrayListOf("Вид шерсти","Окрас")
    private var Сharacteristic_Opicanie:ArrayList<String> = arrayListOf("Короткошерстный","Черный")
    private var  Count:Int = GetСharacteristic().size-1

    fun GetSizeList():Int{
        return Count
    }

    fun SetNick(string: String){
        Nickname=string
    }
    fun GetNick():String{
        return Nickname
    }

    fun SetAge(string: String){
        Age=string
    }

    fun GetAge():String{
        return Age
    }
    fun SetPol(string: String){
        Pol=string
    }
    fun GetPol():String{
        return Pol
    }
    fun SetRace(string: String){
        Race=string
    }
    fun GetRace():String{
        return Race
    }
    fun SetType_of_wool(string: String){

    }
    fun SetСharacteristic(ArrayList:ArrayList<String>){
        Сharacteristic=ArrayList
    }
    fun SetСharacteristic_Opicanie(ArrayList:ArrayList<String>){
        Сharacteristic_Opicanie=ArrayList
    }
    fun GetСharacteristic():ArrayList<String>{
        return Сharacteristic
    }
    fun GetСharacteristic_Opicanie():ArrayList<String>{
        return Сharacteristic_Opicanie
    }
    fun SetChip_Number(string: String){
        Chip_Number=string
    }
    fun GetChip_Number():String{
        return Chip_Number
    }
    fun SetDescription(string: String){
        Pol=string
    }
    fun GetDescription():String{
        return Description
    }

    fun SetInf(nickname:String,race:String,age:String,pol:String,type_of_wool:String,chip_Number:String,description:String){

    }
}