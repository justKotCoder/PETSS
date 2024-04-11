package com.example.pets.amir._class1

import kotlin.random.Random

var Users : ArrayList<User1>?=null
var Petss : ArrayList<Pets1>?=null
fun загр(){
    var User11 :ArrayList<User1> = arrayListOf()
    var Pets11: ArrayList<Pets1> = arrayListOf()
    var Pol:ArrayList<String> = arrayListOf("Мальчик","Девочка")
    for(i in 0..10){
        var user =  User1()
        user.SetName("Пользователь ${i}")
        user.SetAge( i.toString())
        user.SetEmail("mailpozta${i}@mail.ru")
        User11?.add(user)
    }
    Users=User11
    for(i in 0..10){
        var pets =  Pets1()
        var random= Random.nextInt(0,2)
        pets.SetNick("${i}")
        pets.SetAge("${i}")
        pets.SetPol(Pol[random])
        Pets11?.add(pets)
    }
    Petss=Pets11
}

// user.Surname = FireBase.ID(Пользавтеля).Surname
// user.Name = FireBase.ID(Пользавтеля).Name
// user.Age = FireBase.ID(Пользавтеля).Age
// user.Name_Pets = FireBase.ID(Пользавтеля).Pest.ToList()
// For( i in 0..Name_Pets.Size-1){
//     Var Pets = new Pets()
//     Pets.Name =FireBase.ID(Пользавтеля).Pets(user.Name_Pets[i]).Nickname
//     Pets.Age =FireBase.ID(Пользавтеля).Pets(user.Name_Pets[i]).Age
//     Pets.Pol =FireBase.ID(Пользавтеля).Pets(user.Name_Pets[i]).Pol
//     Pets.Race =FireBase.ID(Пользавтеля).Pets(user.Name_Pets[i]).Race
//     user.Pets.add(Pets)
//}

