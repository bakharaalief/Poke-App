package com.bakhdev.pokemon

import com.bakhdev.pokemon.helper.Mapper.toPokemon
import com.bakhdev.pokemon.model.Pokemon
import com.bakhdev.pokemon.remote.PokemonService
import com.bakhdev.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonService: PokemonService) :
    PokemonRepository {

    override fun getPokemons(): Flow<List<Pokemon>> = flow {
        emit(pokemonService.getPokemons())
    }.map { result ->
        result.results?.map {
            val detail = pokemonService.getPokemonSpecies(it?.name ?: "")
            detail.toPokemon()
        } ?: emptyList()
    }
}