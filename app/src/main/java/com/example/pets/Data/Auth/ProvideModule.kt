package com.example.pets.Data.Auth


import com.example.pets.Data.Auth.SignIn.SignInRepositoryImpl
import com.example.pets.Domain.Auth.SignIn.SignInRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
// This module provides repositories implementation
@Module
@InstallIn(SingletonComponent::class)
abstract class ProvideModule {

    @Binds
    abstract fun bindSignInRepository(
        SignInRepositoryImpl: SignInRepositoryImpl
    ): SignInRepository
}