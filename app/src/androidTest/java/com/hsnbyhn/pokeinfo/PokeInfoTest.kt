package com.hsnbyhn.pokeinfo

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hsnbyhn.pokeinfo.ui.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert.assertEquals
import com.google.common.truth.Truth.assertThat

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class PokeInfoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.hsnbyhn.pokeinfo", appContext.packageName)
    }

    @Test
    fun verifyMainActivityInjection() {
        ActivityScenario.launch(MainActivity::class.java).let {
            it.moveToState(Lifecycle.State.CREATED)
            it.onActivity { activity ->
                assertThat(activity.vm).isNotNull()
                activity.vm.pokemonList.observe(activity, Observer { pokemons ->
                    assertThat(pokemons).isNotNull()
                })
            }
        }
    }
}