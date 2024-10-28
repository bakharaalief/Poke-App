package com.bakhdev.home.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.bakhdev.home.components.ListPokemonPaging

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val listPokemonPaging = viewModel.getListPokemonPaging().collectAsLazyPagingItems()

    ListPokemonPaging(listPokemon = listPokemonPaging)
}