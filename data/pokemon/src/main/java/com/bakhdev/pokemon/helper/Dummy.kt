package com.bakhdev.pokemon.helper

import com.bakhdev.pokemon.model.Pokemon

object Dummy {

    fun createPokemonsDummy(): List<Pokemon> {
        val listPokemon: ArrayList<Pokemon> = ArrayList()
        for (i in 0..100) {
            listPokemon.add(
                Pokemon(id = i, name = "bulbasaur", color = "green", url = "google.com")
            )
        }
        return listPokemon
    }

    fun createPokemonDummy(): Pokemon {
        return Pokemon(id = 1, name = "bulbasaur", color = "green", url = "google.com")
    }
}