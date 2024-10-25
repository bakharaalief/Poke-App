package com.bakhdev.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bakhdev.pokemon.helper.Dummy
import com.bakhdev.pokemon.model.Pokemon

@Composable
fun ListPokemon(pokemons: List<Pokemon>) {

    fun onItemClick(pokemon: Pokemon) {
        print(pokemon.name)
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 15.dp),
    ) {
        items(pokemons) {
            PokemonItem(
                pokemon = it,
                onClickItem = { pokemon -> onItemClick(pokemon) }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ListPokemonPreview() {
    ListPokemon(pokemons = Dummy.createPokemonsDummy())
}