package com.github.baraja.feature_joke.di

import com.github.baraja.feature_joke.data.JokeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
class JokeApiModule {

    @Provides
    fun providesJokeApi(retrofitBuilder: Retrofit.Builder): JokeApi {
        return retrofitBuilder
            .baseUrl("https://icanhazdadjoke.com")
            .build()
            .create(JokeApi::class.java)
    }
}