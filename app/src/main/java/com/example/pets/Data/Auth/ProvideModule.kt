package com.example.pets.Data.Auth

import com.example.pets.Domain.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProvideModule {
    @Provides
    fun provideRegistrationImpl() : RegistrationImpl {
        return RegistrationImpl
    }

    @Provides
    fun provideSignUpUseCase(repository: RegistrationImpl) : SignUpUseCase {
        return SignUpUseCase(repository)
    }


}