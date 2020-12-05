package com.hsnbyhn.pokeinfo.repository

import android.util.Log
import com.hsnbyhn.pokeinfo.network.PokeInfoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created by hasanbayhan on 7.11.2020
 **/

class MainRepository @Inject constructor(
    private val pokeInfoApi: PokeInfoApi
) {

    suspend fun fetchPokemonList(
        page: Int,
        onSuccess: () -> Unit
    ) = flow {
        val response = pokeInfoApi.fetchPokemonList(20, page * 20)
        // FIXME: Handle error and success cases
        if(!response.results.isNullOrEmpty()) {
            onSuccess()
            emit(response.results)
        } else {
            //TODO: Add meaningful log
            Log.d("MainRepository", "  Failed")
        }

    }.flowOn(Dispatchers.IO)

    suspend fun fetchPokemonInfo(name: String?) = flow {
        val response = pokeInfoApi.fetchPokemonInfo(name)
        emit(response)
    }.flowOn(Dispatchers.IO)
}