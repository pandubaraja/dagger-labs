package com.github.baraja.feature_joke.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.baraja.base.ViewModelProviderFactory
import com.github.baraja.feature_joke.JokeViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [JokeModule.Binds::class])
class JokeModule {

    @Provides
    fun provideViewModelFactory(jokeViewModel: JokeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(jokeViewModel)
    }

    @Module
    abstract class Binds {

        @dagger.Binds
        abstract fun bindJokeViewModel(viewModel: JokeViewModel): ViewModel
    }
}