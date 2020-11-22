package com.github.baraja.feature_joke.di

import com.github.baraja.feature_joke.di.JokeComponent

interface JokeComponentProvider {
    fun provideJokeComponent(): JokeComponent
}