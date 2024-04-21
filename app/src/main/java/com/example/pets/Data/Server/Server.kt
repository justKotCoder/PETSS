package com.example.pets.Data.Server

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

object Server {

    private const val URL = "https://wpbyjmzpfsovmzxjzmia.supabase.co"
    private const val API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6IndwYnlqbXpwZnNvdm16eGp6bWlhIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MTMzNTc2MjgsImV4cCI6MjAyODkzMzYyOH0.wku3rgUZjvMOCW1qDvRwDNdR4pL0RSeXWUPAiKp-6Pk"

    val server = createSupabaseClient(
        supabaseUrl = URL,
        supabaseKey = API_KEY
    ) {
        install(Postgrest)
        install(Auth)
    }


}