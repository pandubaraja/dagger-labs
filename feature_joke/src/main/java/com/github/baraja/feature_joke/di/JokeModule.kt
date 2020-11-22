package com.github.baraja.feature_joke.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.baraja.base.ViewModelProviderFactory
import com.github.baraja.feature_joke.JokeViewModel
import com.github.baraja.feature_joke.data.JokeRepository
import com.github.baraja.feature_joke.data.JokeRepositoryContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [JokeModule.Binds::class, JokeApiModule::class])
class JokeModule {

    @Provides
    fun provideViewModelFactory(jokeViewModel: JokeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(jokeViewModel)
    }

    @Module
    abstract class Binds {

        @dagger.Binds
        abstract fun bindJokeViewModel(viewModel: JokeViewModel): ViewModel

        @dagger.Binds
        abstract fun bindJokeRepositoryContract(jokeRepository: JokeRepository): JokeRepositoryContract
    }
}