package com.hsnbyhn.pokeinfo.binding

import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.hsnbyhn.pokeinfo.R
import com.hsnbyhn.pokeinfo.ui.view.KeyValueView


/**
 * Created by hasanbayhan on 7.11.2020
 **/

@BindingAdapter("image", "backgroundPalette")
fun bindImage(view: AppCompatImageView, url: String, backgroundPalette: CardView) {
    Glide.with(view.context).load(url).listener(
        GlidePalette.with(url).use(BitmapPalette.Profile.MUTED_LIGHT).intoCallBack {
            it?.dominantSwatch?.rgb?.let {
                backgroundPalette.setCardBackgroundColor(it)
            }
        }.crossfade(true)
    ).into(view)
}


@BindingAdapter("background")
fun bindTypeTextViewBackground(layout: LinearLayout, type: String?) {
    val background = when(type) {
        "fire" -> R.drawable.rounded_rectangle_ce2029_250dp
        "water" -> R.drawable.rounded_rectangle_0077be_250dp
        "grass" -> R.drawable.rounded_rectangle_75f336_250dp
        "flying" -> R.drawable.rounded_rectangle_b0c4de_250dp
        "ice" -> R.drawable.rounded_rectangle_baf2ef_250dp
        else -> R.drawable.rounded_rectangle_db7093_250dp
    }
    layout.setBackgroundResource(background)
}

@BindingAdapter("key", "value")
fun bindText(view: KeyValueView, key: String?, value: String?) {
    view.bindData(key.orEmpty(),value.orEmpty())
}