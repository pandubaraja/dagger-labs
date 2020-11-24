package com.github.baraja.anvilpreview

import com.github.baraja.base.scope.AppScope
import com.github.baraja.feature_joke.di.JokeComponent
import com.squareup.anvil.annotations.MergeComponent

@AppScope
@MergeComponent(AppScope::class)
interface AppComponent {

    fun getJokeComponent(): JokeComponent.Factory
}