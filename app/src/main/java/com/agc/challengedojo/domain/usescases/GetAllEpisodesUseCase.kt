package com.agc.challengedojo.domain.usescases

import com.agc.challengedojo.domain.model.Episode
import com.agc.challengedojo.domain.repository.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllEpisodesUseCase @Inject constructor (private val episodeRepository: EpisodeRepository) {

    fun execute(): Flow<List<Episode>> {
        return episodeRepository.getAllEpisodes()
    }
}