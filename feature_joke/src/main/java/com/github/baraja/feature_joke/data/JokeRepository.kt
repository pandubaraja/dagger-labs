package com.github.baraja.feature_joke.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JokeRepository @Inject constructor(
    val apiService: JokeApi
): JokeRepositoryContract {

    override fun getJoke(): Flow<JokeEntity> {
        return flow {
            val result = apiService.getRandomJoke()
            emit(JokeEntity(result.id, result.joke))
        }
    }
}