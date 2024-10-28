package com.bakhdev.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.bakhdev.core_ui.component.error.ErrorPage
import com.bakhdev.core_ui.component.loading.LoadingPage
import com.bakhdev.core_ui.component.text.CustomText
import com.bakhdev.pokemon.model.PokemonUiModel

@Composable
fun ListPokemonPaging(listPokemon: LazyPagingItems<PokemonUiModel>) {

    fun onItemClick(pokemonUiModel: PokemonUiModel) {
        print(pokemonUiModel.name)
    }

    when (listPokemon.loadState.refresh) {
        is LoadState.Error -> {
            ErrorPage(error = "Error to get Data")
        }

        is LoadState.Loading -> {
            LoadingPage()
        }

        else -> {
            SuccessListPokemonPage(
                listPokemon = listPokemon,
                onItemClick = { pokemon -> onItemClick(pokemon) })
        }
    }
}

@Composable
fun SuccessListPokemonPage(
    listPokemon: LazyPagingItems<PokemonUiModel>,
    onItemClick: (pokemonUiModel: PokemonUiModel) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 15.dp),
    ) {
        //list item
        items(listPokemon.itemCount) { index ->
            listPokemon[index]?.let {
                PokemonItem(
                    pokemonUiModel = it,
                    onClickItem = { pokemon -> onItemClick(pokemon) }
                )
            }
        }

        when (listPokemon.loadState.append) {
            is LoadState.Loading -> {
                item(
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    CustomText(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Loading New Data",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            is LoadState.Error -> {
                item(
                    span = { GridItemSpan(maxLineSpan) }
                ) {
                    CustomText(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Error get Data :(",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }

            else -> {}
        }
    }
}

