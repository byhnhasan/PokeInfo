package com.hsnbyhn.pokeinfo.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by hasanbayhan on 4.10.2020
 **/

abstract class BaseActivity : AppCompatActivity() {

    protected inline fun <reified T: ViewDataBinding> dataBinding(
        @LayoutRes resId: Int
    ) : Lazy<T>  = lazy { DataBindingUtil.setContentView<T>(this, resId) }

}