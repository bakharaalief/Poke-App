package com.bakhdev.pokemon.helper

import com.bakhdev.pokemon.model.PokemonUiModel
import com.bakhdev.pokemon.response.PokemonSpeciesResponse

object Mapper {

    fun PokemonSpeciesResponse?.toPokemon(): PokemonUiModel {
        return PokemonUiModel(
            id = this?.id ?: 0,
            name = this?.name ?: "",
            color = this?.color?.name ?: "",
            url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this?.id ?: 0}.png"
        )
    }
}