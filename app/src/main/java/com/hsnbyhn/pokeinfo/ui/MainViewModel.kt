package com.hsnbyhn.pokeinfo.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.hsnbyhn.pokeinfo.adapter.PokemonItemListener
import com.hsnbyhn.pokeinfo.base.BaseViewModel
import com.hsnbyhn.pokeinfo.data.Pokemon
import com.hsnbyhn.pokeinfo.repository.MainRepository

/**
 * Created by hasanbayhan on 4.10.2020
 **/

class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel(), PokemonItemListener  {

    val pokemonList: LiveData<List<Pokemon>>
    val clickedItem: MutableLiveData<Pokemon?> = MutableLiveData()

    init {
        pokemonList = launchOnViewModelScope {
            mainRepository.fetchPokemonList(
                0,
                onSuccess = {
                    //TODO: Add success logic
                }

                    ).asLiveData()
                }
        }

    override fun onItemClicked(pokemon: Pokemon?) {
        clickedItem.value = pokemon
    }
}