package com.example.pets.Data

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val uuid: String? = null,
    val email: String? = null,
    val password: String? = null,
    val firstName: String = FIRSTNAME_UNKNOWN,
    val lastName: String = LASTNAME_UNKNOWN,
    val rating:Int = DEFAULT_RATING,
    val image: Int? = null
) {
    companion object {
        const val FIRSTNAME_UNKNOWN = "Unknown FirstName"
        const val LASTNAME_UNKNOWN = "Unknown LastName"
        const val DEFAULT_RATING = 0
    }

}
