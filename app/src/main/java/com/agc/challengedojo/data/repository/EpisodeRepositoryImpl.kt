package com.agc.challengedojo.data.repository

import com.agc.challengedojo.data.local.dao.EpisodeDao
import com.agc.challengedojo.data.local.entities.EpisodeEntity
import com.agc.challengedojo.data.remote.api.RickAndMortyApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EpisodeRepositoryImpl @Inject constructor(
    private val apiService: RickAndMortyApiService,
    private val episodeDao: EpisodeDao
) {

    fun getAllEpisodes(): Flow<List<com.agc.challengedojo.domain.model.Episode>> {
        return episodeDao.getAllEpisodes().map { entities ->
            entities.map { it.toDomainModel() }
        }
    }

    suspend fun refreshEpisodes() {
        val episodeDto = apiService.getAllEpisodes()
        val episodes = episodeDto.results.map { it.toEntitys() }
        episodeDao.insertEpisodes(episodes)
    }
}