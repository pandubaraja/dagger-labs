package com.github.baraja.feature_joke.di

import com.github.baraja.feature_joke.data.JokeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class JokeApiModule {

    @Provides
    fun providesJokeApi(retrofitBuilder: Retrofit.Builder): JokeApi {
        return retrofitBuilder
            .baseUrl("https://icanhazdadjoke.com")
            .build()
            .create(JokeApi::class.java)
    }
}