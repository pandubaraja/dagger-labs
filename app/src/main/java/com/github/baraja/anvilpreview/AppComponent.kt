package com.github.baraja.anvilpreview

import com.github.baraja.anvilpreview.module.ApiModule
import com.github.baraja.anvilpreview.module.NetworkModule
import com.github.baraja.anvilpreview.module.RepositoryModule
import com.github.baraja.anvilpreview.module.SubComponentsModule
import com.github.baraja.base.scope.CoreScope
import com.github.baraja.feature_joke.di.JokeComponent
import dagger.Component

@CoreScope
@Component(modules = [
    NetworkModule::class,
    SubComponentsModule::class,
    ApiModule::class,
    RepositoryModule::class
])
interface AppComponent {


    fun getJokeComponent(): JokeComponent.Factory
}