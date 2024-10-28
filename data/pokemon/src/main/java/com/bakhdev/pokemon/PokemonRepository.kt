package com.bakhdev.pokemon

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bakhdev.pokemon.model.PokemonUiModel
import com.bakhdev.pokemon.pagingSource.PokemonPagingSource
import com.bakhdev.pokemon.remote.PokemonService
import com.bakhdev.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonService: PokemonService) :
    PokemonRepository {

    override fun getListPokemonPaging(): Flow<PagingData<PokemonUiModel>> =
        Pager(
            config = PagingConfig(
                pageSize = PokemonPagingSource.PAGE_SIZE
            ),
            pagingSourceFactory = { PokemonPagingSource(pokemonService) }
        ).flow
}