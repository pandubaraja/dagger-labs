package com.github.baraja.feature_joke.data

import com.github.baraja.base.scope.AppScope
import com.squareup.anvil.annotations.ContributesBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ContributesBinding(AppScope::class)
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