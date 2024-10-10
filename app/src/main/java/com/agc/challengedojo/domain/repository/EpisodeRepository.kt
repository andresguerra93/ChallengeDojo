package com.agc.challengedojo.domain.repository

import com.agc.challengedojo.domain.model.Episode
import kotlinx.coroutines.flow.Flow



interface EpisodeRepository {
    fun getAllEpisodes(): Flow<List<Episode>>
    suspend fun refreshEpisodes()
}