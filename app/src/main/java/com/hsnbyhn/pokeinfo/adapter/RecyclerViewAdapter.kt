package com.hsnbyhn.pokeinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hsnbyhn.pokeinfo.data.Pokemon
import com.hsnbyhn.pokeinfo.databinding.PokemonItemViewBinding

/**
 * Created by hasanbayhan on 7.11.2020
 **/

class RecyclerViewAdapter(
    private val listener: PokemonItemListener?
) : RecyclerView.Adapter<RecyclerViewAdapter.PokemonItemViewHolder>() {

    private val items: MutableList<Pokemon> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemViewHolder {
        val binding = PokemonItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonItemViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonItemViewHolder, position: Int) {
        holder.binding.apply {
            this.pokemon = items[position]
            executePendingBindings()
            this.root.setOnClickListener {
                listener?.onItemClicked(items.getOrNull(position))
            }
        }
    }

    fun updateItems(items: MutableList<Pokemon>?) {
        val previous = this.items.size
        this.items.addAll(items ?: mutableListOf())
        this.notifyItemRangeChanged(previous, this.items.size)
    }

    inner class PokemonItemViewHolder(val binding: PokemonItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}

interface PokemonItemListener {
    fun onItemClicked(pokemon: Pokemon?)
}