package com.example.pets.viewModel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.pets._class.List_Tovar
import com.example.pets._class.Tovar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow

class Shoping_ViewModel:ViewModel() {
    private lateinit var auth: FirebaseAuth
    val Products : MutableStateFlow<ArrayList<Tovar>> = MutableStateFlow(List_Tovar!!)
    val count : MutableStateFlow<Double> =MutableStateFlow(Products?.value?.size!!.toDouble())
    var int=0
    fun nomer():Tovar{
        if(int<Products.value.size){
            return Products.value.get(int++)

        }
        return Tovar()
    }

    fun newUser(context: Context, email: String, password: String) {
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}