package com.agc.challengedojo.data.local.entities.converters

import androidx.room.TypeConverter
import com.agc.challengedojo.data.remote.api.dto.character.Location

class LocationConverter {

    @TypeConverter
    fun fromLocation(location: Location): String {
        return "${location.name},${location.url}"
    }

    @TypeConverter
    fun toLocation(value: String): Location {
        val parts = value.split(",")
        return Location(parts[0], parts[1])
    }
}
