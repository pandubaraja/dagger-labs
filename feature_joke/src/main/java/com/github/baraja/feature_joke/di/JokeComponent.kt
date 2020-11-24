package com.github.baraja.feature_joke.di

import com.github.baraja.base.scope.ActivityScope
import com.github.baraja.feature_joke.JokeFragment
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent

@MergeSubcomponent(JokeScope::class)
interface JokeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): JokeComponent
    }

    fun inject(fragment: JokeFragment)
}