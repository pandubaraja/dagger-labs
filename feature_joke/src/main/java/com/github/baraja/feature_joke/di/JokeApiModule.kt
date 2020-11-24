package com.github.baraja.feature_joke.di

import com.github.baraja.base.scope.AppScope
import com.github.baraja.feature_joke.data.JokeApi
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
@ContributesTo(AppScope::class)
class JokeApiModule {

    @AppScope
    @Provides
    fun providesJokeApi(retrofitBuilder: Retrofit.Builder): JokeApi {
        return retrofitBuilder
            .baseUrl("https://icanhazdadjoke.com")
            .build()
            .create(JokeApi::class.java)
    }
}