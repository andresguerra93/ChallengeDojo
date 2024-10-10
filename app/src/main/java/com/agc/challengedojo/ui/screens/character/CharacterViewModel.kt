package com.agc.challengedojo.ui.screens.character



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agc.challengedojo.domain.usescases.GetAllCharactersUseCase
import com.agc.challengedojo.domain.usescases.RefreshCharactersUseCase

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val refreshCharactersUseCase: RefreshCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterState())
    val state: StateFlow<CharacterState> = _state.asStateFlow()

    init {
        fetchCharacters()
    }

    fun fetchCharacters() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            getAllCharactersUseCase.execute()
                .onStart { _state.value = state.value.copy(isLoading = true) }
                .catch { e -> _state.value = state.value.copy(errorMessage = e.message, isLoading = false) }
                .collect { characters ->
                    _state.value = state.value.copy(characters = characters, isLoading = false)
                }
        }
    }

    fun refreshCharacters() {
        viewModelScope.launch {
            refreshCharactersUseCase.execute()
            fetchCharacters()  // Refresh characters after refreshing
        }
    }
}
