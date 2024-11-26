package com.bakhdev.pokemon.di

import com.bakhdev.pokemon.remote.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }
}