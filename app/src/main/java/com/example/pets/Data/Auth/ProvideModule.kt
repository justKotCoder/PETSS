package com.example.pets.Data.Auth

import com.example.pets.Data.Auth.SignIn.SignInRepositoryImpl
import com.example.pets.Data.Auth.SignUp.SignUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//That module provides repositories implementation
@Module
@InstallIn(SingletonComponent::class)
object ProvideModule {
    @Provides
    fun provideRegistrationImpl() : SignUpRepositoryImpl {
        return SignUpRepositoryImpl
    }

    @Provides
    fun provideSignInRepositoryImpl() : SignInRepositoryImpl {
        return SignInRepositoryImpl
    }



}