package com.agc.challengedojo.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.agc.challengedojo.data.local.entities.converters.LocationConverter
import com.agc.challengedojo.data.remote.api.dto.character.Location

@Entity(tableName = "character_table")
@TypeConverters(LocationConverter::class)
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "location") @TypeConverters(LocationConverter::class) val location: Location,
    @ColumnInfo(name = "created") val created: String,
    )