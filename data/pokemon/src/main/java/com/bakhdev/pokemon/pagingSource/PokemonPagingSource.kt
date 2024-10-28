package com.bakhdev.pokemon.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bakhdev.pokemon.helper.Mapper.toPokemon
import com.bakhdev.pokemon.model.PokemonUiModel
import com.bakhdev.pokemon.remote.PokemonService
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val pokemonService: PokemonService
) : PagingSource<Int, PokemonUiModel>() {

    override fun getRefreshKey(state: PagingState<Int, PokemonUiModel>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(PAGE_SIZE) ?: anchorPage?.nextKey?.minus(PAGE_SIZE)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonUiModel> {
        return try {
            val offset = params.key ?: 0
            val responseData = pokemonService.getListPokemonPaging(offset, PAGE_SIZE)
            LoadResult.Page(
                data = responseData.results?.map {
                    val detail = pokemonService.getPokemonSpecies(it?.name ?: "")
                    detail.toPokemon()
                } ?: emptyList(),
                prevKey = if (offset == 0) null else offset - PAGE_SIZE,
                nextKey = if (offset >= MAX_PAGE_SIZE) null else offset + PAGE_SIZE
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        const val PAGE_SIZE = 20;
        private const val MAX_PAGE_SIZE = 1302
    }
}