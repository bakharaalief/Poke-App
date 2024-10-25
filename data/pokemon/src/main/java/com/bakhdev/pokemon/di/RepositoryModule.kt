package com.bakhdev.pokemon.di

import com.bakhdev.pokemon.PokemonRepositoryImpl
import com.bakhdev.pokemon.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun providePokemonRepository(pokemonRepositoryImpl: PokemonRepositoryImpl): PokemonRepository
}