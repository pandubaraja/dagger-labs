package com.github.baraja.feature_joke.di

import com.github.baraja.feature_joke.data.JokeRepository
import com.github.baraja.feature_joke.data.JokeRepositoryContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class JokeRepositoryModule {

    @Binds
    abstract fun bindJokeRepositoryContract(jokeRepository: JokeRepository): JokeRepositoryContract
}