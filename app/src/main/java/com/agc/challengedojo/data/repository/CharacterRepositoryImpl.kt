package com.agc.challengedojo.data.repository

import com.agc.challengedojo.data.local.dao.CharacterDao
import com.agc.challengedojo.data.local.entities.CharacterEntity
import com.agc.challengedojo.data.mappers.toDomainModel

import com.agc.challengedojo.data.remote.api.RickAndMortyApiService
import com.agc.challengedojo.data.remote.api.dto.character.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val apiService: RickAndMortyApiService,
    private val characterDao: CharacterDao
) {

    fun getAllCharacters(): Flow<List<com.agc.challengedojo.domain.model.Character>> {
        return characterDao.getAllCharacters().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    suspend fun refreshCharacters() {
        val characterDto = apiService.getAllCharacters()
        val characters = characterDto.results.map { it.toEntity() }
        characterDao.insertCharacters(characters)
    }
}

