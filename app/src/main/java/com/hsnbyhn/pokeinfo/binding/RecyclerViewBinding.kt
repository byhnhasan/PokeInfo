package com.hsnbyhn.pokeinfo.binding

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hsnbyhn.pokeinfo.adapter.PokemonItemListener
import com.hsnbyhn.pokeinfo.adapter.PokemonTypeRecyclerViewAdapter
import com.hsnbyhn.pokeinfo.adapter.RecyclerViewAdapter
import com.hsnbyhn.pokeinfo.data.Pokemon
import com.hsnbyhn.pokeinfo.data.PokemonInfo

/**
 * Created by hasanbayhan on 8.11.2020
 **/

@BindingAdapter("data", "listener")
fun bindRecyclerView(view: RecyclerView, data: MutableList<Pokemon>?, listener: PokemonItemListener) {
    view.layoutManager = GridLayoutManager(view.context, 2)
    view.adapter = RecyclerViewAdapter(listener)
    (view.adapter as RecyclerViewAdapter).updateItems(data)
}

@BindingAdapter("typeList")
fun bindTypeRecyclerView(view: RecyclerView, data: MutableList<PokemonInfo.PokemonType>?) {
    val adapter = PokemonTypeRecyclerViewAdapter(data ?: mutableListOf())
    view.apply {
        this.layoutManager = GridLayoutManager(view.context, 2)
        this.adapter = adapter
    }
    adapter.notifyDataSetChanged()
}