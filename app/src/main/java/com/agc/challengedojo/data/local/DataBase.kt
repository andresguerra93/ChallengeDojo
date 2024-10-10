package com.agc.challengedojo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agc.challengedojo.data.local.dao.CharacterDao
import com.agc.challengedojo.data.local.dao.EpisodeDao
import com.agc.challengedojo.data.local.entities.CharacterEntity
import com.agc.challengedojo.data.local.entities.EpisodeEntity

@Database(entities = [CharacterEntity::class, EpisodeEntity::class], version = 1, exportSchema = true)
abstract class DataBase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun episodeDao(): EpisodeDao

}