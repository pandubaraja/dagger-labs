package com.github.baraja.feature_joke

import com.github.baraja.feature_joke.data.JokeEntity

sealed class JokeUiState {
    object Default: JokeUiState()
    object Loading: JokeUiState()
    data class Success(val joke: JokeEntity?): JokeUiState()
    data class Error(val exception: Throwable): JokeUiState()
}