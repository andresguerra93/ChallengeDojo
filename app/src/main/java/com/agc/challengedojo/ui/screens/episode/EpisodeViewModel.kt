package com.agc.challengedojo.ui.screens.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agc.challengedojo.domain.usescases.GetAllEpisodesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class EpisodeViewModel(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(EpisodeState())
    val state: StateFlow<EpisodeState> = _state.asStateFlow()

    init {
        fetchEpisodes()
    }

    fun fetchEpisodes() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            getAllEpisodesUseCase.execute()
                .onStart { _state.value = state.value.copy(isLoading = true) }
                .catch { e -> _state.value = state.value.copy(errorMessage = e.message, isLoading = false) }
                .collect { episodes ->
                    _state.value = state.value.copy(episodes = episodes, isLoading = false)
                }
        }
    }
}