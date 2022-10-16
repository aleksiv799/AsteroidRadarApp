package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.RoomConstants

@Dao
interface PictureOfDayDao {

    @Query(RoomConstants.GET_PICTURE_OF_DAY)
    fun getPictureOfDay(): LiveData<PicturesOfDayEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPictureOfDay(picture: PicturesOfDayEntity)
}