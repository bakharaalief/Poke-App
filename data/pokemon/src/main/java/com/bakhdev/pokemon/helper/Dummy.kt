package com.bakhdev.pokemon.helper

import com.bakhdev.pokemon.model.PokemonUiModel

object Dummy {

    fun createPokemonsDummy(): List<PokemonUiModel> {
        val listPokemonUiModel: ArrayList<PokemonUiModel> = ArrayList()
        for (i in 0..100) {
            listPokemonUiModel.add(
                PokemonUiModel(id = i, name = "bulbasaur", color = "green", url = "google.com")
            )
        }
        return listPokemonUiModel
    }

    fun createPokemonDummy(): PokemonUiModel {
        return PokemonUiModel(id = 1, name = "bulbasaur", color = "green", url = "google.com")
    }
}