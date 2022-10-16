package com.udacity.asteroidradar.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.udacity.asteroidradar.RoomConstants


@Dao
interface AsteroidDao {
    @Query(RoomConstants.GET_ALL_NEAR_EARTH_OBJECTS)
    fun getAllAsteroids(): LiveData<List<AsteroidEntity>>

    @Query(RoomConstants.GET_WEEKLY_NEAR_EARTH_OBJECTS)
    fun getWeeklyAsteroids(startDate: String, endDate: String): LiveData<List<AsteroidEntity>>

    @Query(RoomConstants.GET_TODAY_OBJECTS)
    fun getTodayAsteroids(today: String): LiveData<List<AsteroidEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg asteroids: AsteroidEntity)
}