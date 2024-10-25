package com.bakhdev.pokemon.remote

import com.bakhdev.pokemon.response.PokemonSpeciesResponse
import com.bakhdev.pokemon.response.PokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET("pokemon")
    suspend fun getPokemons(): PokemonsResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): PokemonSpeciesResponse
}