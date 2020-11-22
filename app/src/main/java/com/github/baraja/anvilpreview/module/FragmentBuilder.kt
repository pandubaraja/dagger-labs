package com.github.baraja.anvilpreview.module

import com.github.baraja.feature_joke.JokeFragment
import com.github.baraja.feature_joke.di.JokeModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [JokeModule::class])
    abstract fun bindsJokeFragment(): JokeFragment
}