package com.bakhdev.pokemon.repository

import androidx.paging.PagingData
import com.bakhdev.pokemon.model.PokemonUiModel
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getListPokemonPaging(): Flow<PagingData<PokemonUiModel>>
}