package com.example.pets.amir._class1

import com.example.pets._class.Pets



class User1 {
    private var Surname ="Иванов"
    private var Name="Иван"
    private var Vatersname="Иванов"
    private var Age="21"
    private var Animals:ArrayList<Pets>?=null
    private var Email:String?=null
    private var Nomer_telefona:String?=null

    fun SetSurname(string: String){
        Surname=string
    }
    fun GetSurname():String{
        return Surname;
    }
    fun SetName(string: String){
        Name =string
    }
    fun GetName():String{
        return Name;
    }
    fun SetVatersname(string: String){
        Vatersname=string
    }
    fun GetVatersname():String{
        return Vatersname
    }
    fun SetAge(string: String){
        Age= string;
    }
    fun GetAge():String{
        return Age
    }
    fun SetAnimals(pets: Pets){
        Animals?.add(pets)
    }
    fun GetAnimals():ArrayList<Pets>{
        return Animals!!
    }
    fun SetEmail(string: String){
        Email=string
    }
    fun GetEmail():String{
        return Email!!
    }
    fun SetNomer_Telefona(string: String){
        Nomer_telefona=string
    }
    fun GetNomer_Telefona():String{
        return Nomer_telefona!!
    }
}