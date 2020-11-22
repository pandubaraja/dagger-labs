package com.github.baraja.anvilpreview

import com.github.baraja.base.BaseApp
import com.github.baraja.feature_joke.di.JokeComponent
import com.github.baraja.feature_joke.di.JokeComponentProvider

class App: BaseApp(), JokeComponentProvider {

    private val _appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun provideJokeComponent(): JokeComponent {
        return _appComponent.getJokeComponent().create()
    }
}