package com.bakhdev.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.bakhdev.home.components.ListPokemon

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val pokemons by remember { viewModel.getPokemons() }.collectAsState(initial = listOf())

    ListPokemon(pokemons = pokemons)
}