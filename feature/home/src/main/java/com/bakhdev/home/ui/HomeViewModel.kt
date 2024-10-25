package com.bakhdev.home.ui

import androidx.lifecycle.ViewModel
import com.bakhdev.pokemon.model.Pokemon
import com.bakhdev.pokemon.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    fun getPokemons(): Flow<List<Pokemon>> = pokemonRepository.getPokemons()
}