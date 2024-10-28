package com.bakhdev.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bakhdev.pokemon.model.PokemonUiModel
import com.bakhdev.pokemon.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    fun getListPokemonPaging(): Flow<PagingData<PokemonUiModel>> =
        pokemonRepository.getListPokemonPaging().cachedIn(viewModelScope)
}