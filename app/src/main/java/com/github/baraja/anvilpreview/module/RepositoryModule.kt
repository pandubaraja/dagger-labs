package com.github.baraja.anvilpreview.module

import com.github.baraja.base.scope.CoreScope
import com.github.baraja.feature_joke.data.JokeRepository
import com.github.baraja.feature_joke.data.JokeRepositoryContract
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @CoreScope
    @Binds
    abstract fun bindJokeRepositoryContract(jokeRepository: JokeRepository): JokeRepositoryContract
}