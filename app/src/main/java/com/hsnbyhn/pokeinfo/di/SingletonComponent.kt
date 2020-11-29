package com.hsnbyhn.pokeinfo.di

import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by hasanbayhan on 28.10.2020
 **/

@Singleton
@DefineComponent(parent = ApplicationComponent::class)
interface SingletonComponent
