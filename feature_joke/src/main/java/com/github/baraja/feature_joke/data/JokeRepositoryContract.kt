package com.github.baraja.feature_joke.data

import kotlinx.coroutines.flow.Flow

interface JokeRepositoryContract {

    fun getJoke(): Flow<JokeEntity>
}