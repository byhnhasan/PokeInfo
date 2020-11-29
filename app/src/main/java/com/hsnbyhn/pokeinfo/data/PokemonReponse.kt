package com.hsnbyhn.pokeinfo.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by hasanbayhan on 10.10.2020
 **/

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @field:Json(name = "count") val count: Int,
    @field:Json(name = "next") val next: String?,
    @field:Json(name = "previous") val previous: String?,
    @field:Json(name = "results") val results: List<Pokemon>
)