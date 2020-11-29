package com.hsnbyhn.pokeinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsnbyhn.pokeinfo.data.PokemonInfo
import com.hsnbyhn.pokeinfo.databinding.PokemonItemTypeViewBinding

/**
 * Created by hasanbayhan on 28.11.2020
 **/

class PokemonTypeRecyclerViewAdapter(
    private val items: MutableList<PokemonInfo.PokemonType>
) : RecyclerView.Adapter<PokemonTypeRecyclerViewAdapter.PokemonItemTypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemTypeViewHolder {
       val binding = PokemonItemTypeViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonItemTypeViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonItemTypeViewHolder, position: Int) {
        holder.binding.apply {
            pokemonType = items[position]
            executePendingBindings()
        }

    }

    inner class PokemonItemTypeViewHolder(val binding: PokemonItemTypeViewBinding) : RecyclerView.ViewHolder(binding.root)

}