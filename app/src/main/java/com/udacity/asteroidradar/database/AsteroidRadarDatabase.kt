package com.udacity.asteroidradar.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PicturesOfDayEntity::class, AsteroidEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AsteroidRadarDatabase : RoomDatabase() {

    abstract val pictureOfDayDao: PictureOfDayDao
    abstract val asteroidDao: AsteroidDao

    companion object {
        private lateinit var INSTANCE: AsteroidRadarDatabase

        fun getDatabase(context: Context): AsteroidRadarDatabase {
            synchronized(AsteroidRadarDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AsteroidRadarDatabase::class.java, "AsteroidDatabase"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}