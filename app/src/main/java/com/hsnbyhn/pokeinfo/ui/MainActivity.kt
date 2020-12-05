package com.hsnbyhn.pokeinfo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.Observer
import com.hsnbyhn.pokeinfo.R
import com.hsnbyhn.pokeinfo.base.BaseActivity
import com.hsnbyhn.pokeinfo.databinding.ActivityMainBinding
import com.hsnbyhn.pokeinfo.ui.detail.PokemonDetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val TAG = "MainActivity"

    private val binding: ActivityMainBinding by dataBinding(R.layout.activity_main)
    @VisibleForTesting val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = vm.apply { }
        }
        binding.viewModel?.clickedItem?.observe(this, Observer {
            val fragment = PokemonDetailFragment.newInstance(it)
            fragment.show(supportFragmentManager, "POKEMON_DETAIL_FRAGMENT")
        })
    }
}