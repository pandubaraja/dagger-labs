package com.github.baraja.anvilpreview.module

import com.github.baraja.base.scope.CoreScope
import com.github.baraja.feature_joke.data.JokeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @CoreScope
    @Provides
    fun providesJokeApi(retrofitBuilder: Retrofit.Builder): JokeApi {
        return retrofitBuilder
            .baseUrl("https://icanhazdadjoke.com")
            .build()
            .create(JokeApi::class.java)
    }
}