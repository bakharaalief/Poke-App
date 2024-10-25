package com.bakhdev.pokemon.repository

import com.bakhdev.pokemon.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemons(): Flow<List<Pokemon>>
}