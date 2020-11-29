package com.hsnbyhn.pokeinfo.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hsnbyhn.pokeinfo.R
import com.hsnbyhn.pokeinfo.data.Pokemon
import com.hsnbyhn.pokeinfo.databinding.FragmentPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hasanbayhan on 27.11.2020
 **/

@AndroidEntryPoint
class PokemonDetailFragment : DialogFragment() {

    private val TAG = "PokemonDetailFragment"

    private var binding: FragmentPokemonDetailBinding? = null

    @VisibleForTesting
    val vm: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val item: Pokemon? = arguments?.getParcelable(POKEMON_ITEM)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pokemon_detail, container, false)
        binding?.apply {
            pokemon = item
            lifecycleOwner = viewLifecycleOwner
            viewModel = vm.apply { getSelectedPokemonName(pokemon!!.name) }
        }
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return binding?.root

    }

    companion object {

        private const val POKEMON_ITEM = "POKEMON_ITEM"

        fun newInstance(item: Pokemon) =
            PokemonDetailFragment().apply {
                this.arguments = Bundle().apply {
                    putParcelable(POKEMON_ITEM, item)
                }
            }
    }
}