package com.agc.challengedojo.domain.usescases

import com.agc.challengedojo.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor (private val characterRepository: CharacterRepository) {

    fun execute(): Flow<List<Character>> {
        return characterRepository.getAllCharacters()
    }

}


