package com.hsnbyhn.pokeinfo.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.hsnbyhn.pokeinfo.databinding.KeyValueViewBinding

/**
 * Created by hasanbayhan on 29.11.2020
 **/

class KeyValueView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var binding: KeyValueViewBinding? = null

    init {
        orientation = HORIZONTAL
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        binding = KeyValueViewBinding.inflate(LayoutInflater.from(context), this)
    }

    fun bindData(key: String, value: String) {
        binding?.let {
            it.key.text = key
            it.value.text = value
        }
    }
}