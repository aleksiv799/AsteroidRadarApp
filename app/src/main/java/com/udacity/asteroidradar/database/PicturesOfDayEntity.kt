package com.udacity.asteroidradar.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.udacity.asteroidradar.domain.PictureOfDay

@Entity
data class PicturesOfDayEntity constructor(

    @PrimaryKey
    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "mediaType")
    val mediaType: String,

    @ColumnInfo(name = "title")
    val title: String
)

fun PicturesOfDayEntity.asDomainModel(): PictureOfDay {
    return PictureOfDay(url, mediaType, title)
}