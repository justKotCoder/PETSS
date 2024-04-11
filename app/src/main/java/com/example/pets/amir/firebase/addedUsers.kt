package com.example.pets.amir.firebase

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

fun addUsers(email: String, password: String, context: Context){
    lateinit var auth: FirebaseAuth
    auth = Firebase.auth
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
            } else {
                Toast.makeText(context, Toast.LENGTH_LONG, Toast.LENGTH_LONG).show()
            }
        }
}