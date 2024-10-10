package com.agc.challengedojo.domain.repository

import com.agc.challengedojo.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<List<Character>>
    suspend fun refreshCharacters()
}
