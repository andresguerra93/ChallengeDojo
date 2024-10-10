package com.agc.challengedojo.ui.screens.character

data class CharacterState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)