package com.github.baraja.anvilpreview.module

import com.github.baraja.feature_joke.di.JokeComponent
import dagger.Module

@Module(subcomponents = [JokeComponent::class])
class SubComponentsModule