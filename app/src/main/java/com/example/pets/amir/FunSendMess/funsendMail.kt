package com.example.pets.logic.asynkClass.FunSendMess

import com.example.pets.amir.AsynkClasses.SendMailTask


import java.util.*


fun sendNessage(mail: String): String {
    val codeOfFive= Random()
    val numbers= codeOfFive.nextInt(999999)
    val sendMailTask =
        SendMailTask(
            mail,
            "Code",
            "Code verification",
            numbers.toString()
        )
    sendMailTask.execute()
    return numbers.toString()
}