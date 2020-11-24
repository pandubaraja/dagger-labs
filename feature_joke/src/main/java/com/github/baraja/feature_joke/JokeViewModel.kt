package com.github.baraja.feature_joke

import androidx.lifecycle.ViewModel
import com.github.baraja.feature_joke.data.JokeRepositoryContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class JokeViewModel @Inject constructor(
    val jokeRepository: JokeRepositoryContract
): ViewModel(), CoroutineScope {

    private val supervisorJob: Job = Job()
    private val _uiState = MutableStateFlow<JokeUiState>(JokeUiState.Default)
    val uiState: StateFlow<JokeUiState> = _uiState

    fun fetchJoke() {
        launch(Dispatchers.Main) {
            _uiState.value = JokeUiState.Loading
            jokeRepository.getJoke()
                .flowOn(Dispatchers.IO)
                .collect {
                    _uiState.value = JokeUiState.Success(it)
                }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = supervisorJob
}

