package com.udacity.asteroidradar.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.udacity.asteroidradar.database.AsteroidEntity
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.database.PicturesOfDayEntity

@JsonClass(generateAdapter = true)
data class NetworkPictureOfDay(
    val url: String,
    val date: String,
    @Json(name = "media_type") val mediaType: String,
    val title: String
)


fun NetworkPictureOfDay.asDatabaseModel(): PicturesOfDayEntity {
    return PicturesOfDayEntity(
        url,
        date,
        mediaType,
        title
    )
}

fun List<Asteroid>.asDatabaseModel(): Array<AsteroidEntity> {
    return map {
        AsteroidEntity(
            id = it.id,
            codename = it.codename,
            closeApproachDate = it.closeApproachDate,
            absoluteMagnitude = it.absoluteMagnitude,
            estimatedDiameter = it.estimatedDiameter,
            relativeVelocity = it.relativeVelocity,
            distanceFromEarth = it.distanceFromEarth,
            isPotentiallyHazardous = it.isPotentiallyHazardous
        )
    }.toTypedArray()
}