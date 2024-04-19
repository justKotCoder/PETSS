package com.example.pets.Data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val uuid: String,
    val firstName: String,
    val lastName: String,
    val rating:Int,
    val image: Int
)
