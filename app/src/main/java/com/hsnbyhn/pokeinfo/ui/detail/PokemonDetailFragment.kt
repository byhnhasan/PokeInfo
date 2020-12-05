package com.hsnbyhn.pokeinfo.ui.detail

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
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
        val back = ColorDrawable(Color.TRANSPARENT)
        dialog?.window?.setBackgroundDrawable(InsetDrawable(back, 20, 0, 20, 0))
        return binding?.root

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        val decorView = dialog?.window?.decorView
        val animator = ObjectAnimator.ofPropertyValuesHolder(
            decorView,
            PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f),
            PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f),
            PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f)
        )
        animator.duration = 1000
        animator.start()
    }

    companion object {

        private const val POKEMON_ITEM = "POKEMON_ITEM"

        fun newInstance(item: Pokemon?) =
            PokemonDetailFragment().apply {
                this.arguments = Bundle().apply {
                    putParcelable(POKEMON_ITEM, item)
                }
            }
    }
}