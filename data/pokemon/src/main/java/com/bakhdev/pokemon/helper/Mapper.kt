package com.bakhdev.pokemon.helper

import com.bakhdev.pokemon.model.Pokemon
import com.bakhdev.pokemon.response.PokemonSpeciesResponse

object Mapper {

    fun PokemonSpeciesResponse?.toPokemon(): Pokemon {
        return Pokemon(
            id = this?.id ?: 0,
            name = this?.name ?: "",
            color = this?.color?.name ?: "",
            url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this?.id ?: 0}.png"
        )
    }
}