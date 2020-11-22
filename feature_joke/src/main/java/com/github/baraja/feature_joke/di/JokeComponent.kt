package com.github.baraja.feature_joke.di

import com.github.baraja.base.scope.FragmentScope
import com.github.baraja.feature_joke.JokeFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent(
    modules = [JokeModule::class]
)
interface JokeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): JokeComponent
    }

    fun inject(fragment: JokeFragment)
}