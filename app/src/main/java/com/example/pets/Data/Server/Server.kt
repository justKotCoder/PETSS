package com.example.pets.Data.Server

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Singleton
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DatabaseConnectionManager {

    companion object {
        // Вписать айпи ПК, на котором запущена БД. (ipconfig в cmd)
        // В будущем сделать автоматическую адресацию на удаленный сервер.
        private const val DB_URL ="jdbc:postgresql://10.0.0.104:5432/pet_passport_db?connectTimeout=10&socketTimeout=10"
        private const val USER = "pet_passport_user"
        private const val PASS = "1234"
    }

    suspend fun getConnection(): Connection = withContext(Dispatchers.IO) {
        try {
            Class.forName("org.postgresql.Driver")
            val connection = DriverManager.getConnection(DB_URL, USER, PASS)
            println("Connection successful!")
            connection
        } catch (e: ClassNotFoundException) {
            throw RuntimeException("PostgreSQL JDBC Driver not found.", e)
        } catch (e: SQLException) {
            throw RuntimeException("Connection to database failed.", e)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object DatabaseModule {

        @Provides
        @Singleton
        fun provideDatabaseConnectionManager(): DatabaseConnectionManager {
            return DatabaseConnectionManager()
        }
    }
}