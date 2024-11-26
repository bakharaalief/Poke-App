package com.bakhdev.pokemon.remote

import com.bakhdev.pokemon.response.ListPokemonResponse
import com.bakhdev.pokemon.response.PokemonSpeciesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    suspend fun getListPokemonPaging(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): ListPokemonResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): PokemonSpeciesResponse
}