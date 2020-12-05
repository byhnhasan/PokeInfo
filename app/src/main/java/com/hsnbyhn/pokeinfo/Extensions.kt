package com.hsnbyhn.pokeinfo

/**
 * Created by hasanbayhan on 30.11.2020
 **/

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}