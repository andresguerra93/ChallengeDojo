package com.agc.challengedojo.domain.usescases

import com.agc.challengedojo.domain.repository.CharacterRepository


class RefreshCharactersUseCase(private val characterRepository: CharacterRepository) {

    suspend fun execute() {
        characterRepository.refreshCharacters()
    }
}
