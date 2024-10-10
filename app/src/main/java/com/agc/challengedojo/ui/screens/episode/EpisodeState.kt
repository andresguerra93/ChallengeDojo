package com.agc.challengedojo.ui.screens.episode

import com.agc.challengedojo.domain.model.Episode

data class EpisodeState(
    val episodes: List<Episode> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)