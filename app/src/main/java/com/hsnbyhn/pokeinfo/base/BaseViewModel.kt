package com.hsnbyhn.pokeinfo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

/**
 * Created by hasanbayhan on 4.10.2020
 **/

abstract class BaseViewModel : ViewModel() {
    inline fun <T> launchOnViewModelScope(crossinline block: suspend () -> LiveData<T>): LiveData<T>  {
      return liveData(viewModelScope.coroutineContext + Dispatchers.IO) {
          emitSource(block())
      }
    }

}