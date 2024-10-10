package com.agc.challengedojo.data.remote.api

import com.agc.challengedojo.data.remote.api.dto.character.CharacterDto
import com.agc.challengedojo.data.remote.api.dto.episode.EpisodeDto
import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("episode")
    suspend fun getAllEpisodes(): CharacterDto

    @GET("character")
    suspend fun getAllCharacters(): EpisodeDto
}
