package com.hsnbyhn.pokeinfo

import com.hsnbyhn.pokeinfo.data.Pokemon

/**
 * Created by hasanbayhan on 6.12.2020
 **/
object MockData {

    fun getMockPokemon() = Pokemon(name = "balbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/")
}