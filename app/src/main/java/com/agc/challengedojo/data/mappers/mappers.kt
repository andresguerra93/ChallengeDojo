package com.agc.challengedojo.data.mappers

import com.agc.challengedojo.data.local.entities.CharacterEntity
import com.agc.challengedojo.data.local.entities.EpisodeEntity
import com.agc.challengedojo.data.remote.api.dto.character.Result
import com.agc.challengedojo.domain.model.Character
import com.agc.challengedojo.domain.model.Episode
import com.agc.challengedojo.domain.model.Location

fun CharacterEntity.toDomainModel(): com.agc.challengedojo.domain.model.Character {
    return com.agc.challengedojo.domain.model.Character(
        id = this.id,
        name = this.name,
        location = Location(this.location.name, this.location.url),
        created = this.created
    )
}

fun Result.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = this.id,
        name = this.name,
        location = com.agc.challengedojo.data.remote.api.dto.character.Location(this.location.name, this.location.url),
        created = this.created
    )
}

fun EpisodeEntity.toDomainModel(): Episode {
    return Episode(
        id = this.id,
        name = this.name,
        episode = this.episode,
        airDate = this.airDate
    )
}

fun com.agc.challengedojo.data.remote.api.dto.episode.Result.toEntitys(): EpisodeEntity {
    return EpisodeEntity(
        id = this.id,
        name = this.name,
        episode = this.episode,
        airDate = this.air_date
    )
}
