package com.udacity.asteroidradar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.udacity.asteroidradar.domain.Asteroid

@Entity
data class AsteroidEntity constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "codename")
    val codename: String,

    @ColumnInfo(name = "closeApproachDate")
    val closeApproachDate: String,

    @ColumnInfo(name = "absoluteMagnitude")
    val absoluteMagnitude: Double,

    @ColumnInfo(name = "estimatedDiameter")
    val estimatedDiameter: Double,

    @ColumnInfo(name = "relativeVelocity")
    val relativeVelocity: Double,

    @ColumnInfo(name = "distanceFromEarth")
    val distanceFromEarth: Double,

    @ColumnInfo(name = "isPotentiallyHazardous")
    val isPotentiallyHazardous: Boolean
)

fun List<AsteroidEntity>.asDomainModel(): List<Asteroid> {
    return map { asteroid ->
        Asteroid(
            id = asteroid.id,
            codename = asteroid.codename,
            closeApproachDate = asteroid.closeApproachDate,
            absoluteMagnitude = asteroid.absoluteMagnitude,
            estimatedDiameter = asteroid.estimatedDiameter,
            relativeVelocity = asteroid.relativeVelocity,
            distanceFromEarth = asteroid.distanceFromEarth,
            isPotentiallyHazardous = asteroid.isPotentiallyHazardous
        )
    }
}