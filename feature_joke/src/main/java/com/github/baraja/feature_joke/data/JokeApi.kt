package com.github.baraja.feature_joke.data

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeApi {

    @Headers("Accept: application/json")
    @GET("/")
    suspend fun getRandomJoke(): JokeResponse
}