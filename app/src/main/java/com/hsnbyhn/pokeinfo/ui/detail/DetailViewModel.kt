package com.hsnbyhn.pokeinfo.ui.detail

import androidx.annotation.MainThread
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.hsnbyhn.pokeinfo.base.BaseViewModel
import com.hsnbyhn.pokeinfo.data.PokemonInfo
import com.hsnbyhn.pokeinfo.repository.MainRepository
import kotlin.random.Random

/**
 * Created by hasanbayhan on 23.11.2020
 **/

class DetailViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    val pokemonInfo: LiveData<PokemonInfo>

    private var pokemonName: MutableLiveData<String> = MutableLiveData()
    val weightText = "Weight"
    val heightText = "Height"
    val hp =  Random.nextInt(100)
    val atk = Random.nextInt(100)
    val def = Random.nextInt(100)
    val spd = Random.nextInt(100)

    init {
        pokemonInfo = pokemonName.switchMap {
            launchOnViewModelScope {
                mainRepository.fetchPokemonInfo(it).asLiveData()
            }
        }
    }

    @MainThread
    fun getSelectedPokemonName(name: String) {
        pokemonName.value = name
    }

}