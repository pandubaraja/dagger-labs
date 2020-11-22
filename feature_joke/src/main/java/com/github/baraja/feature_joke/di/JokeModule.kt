package com.github.baraja.feature_joke.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.baraja.base.ViewModelProviderFactory
import com.github.baraja.feature_joke.JokeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

@Module(includes = [JokeModule.Binds::class])
@InstallIn(ActivityComponent::class)
class JokeModule {

    @Provides
    fun provideViewModelFactory(jokeViewModel: JokeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(jokeViewModel)
    }

    @Module
    @InstallIn(ActivityComponent::class)
    abstract class Binds {

        @dagger.Binds
        abstract fun bindJokeViewModel(viewModel: JokeViewModel): ViewModel
    }
}