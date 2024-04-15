package com.example.pets.screens.servises

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun Servises(){
    val personRepository = PersonRepository()
    val getAllData = personRepository.getAllData()

    LazyColumn(contentPadding = PaddingValues(all = 12.dp),
    verticalArrangement = Arrangement.spacedBy(12.dp)){
        itemsIndexed(items = getAllData){index, person ->
            Log.d("MainActivi",index.toString())
            CustomItem(person = person)
        }
    }
}

