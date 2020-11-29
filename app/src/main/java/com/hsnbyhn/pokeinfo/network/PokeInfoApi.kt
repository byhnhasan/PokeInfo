package com.hsnbyhn.pokeinfo.network

import com.hsnbyhn.pokeinfo.data.PokemonInfo
import com.hsnbyhn.pokeinfo.data.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by hasanbayhan on 10.10.2020
 **/
interface PokeInfoApi {

    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String?): PokemonInfo
}