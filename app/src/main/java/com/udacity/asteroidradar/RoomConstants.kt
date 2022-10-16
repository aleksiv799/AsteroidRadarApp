package com.udacity.asteroidradar

object RoomConstants {

    const val GET_PICTURE_OF_DAY = "SELECT * FROM PicturesOfDayEntity pod ORDER BY pod.date DESC LIMIT 0,1"
    const val GET_ALL_NEAR_EARTH_OBJECTS = "select * from AsteroidEntity order by closeApproachDate desc"
    const val GET_WEEKLY_NEAR_EARTH_OBJECTS = "SELECT * FROM AsteroidEntity obj WHERE obj.closeApproachDate BETWEEN :startDate  AND :endDate  order by closeApproachDate desc"
    const val GET_TODAY_OBJECTS = "SELECT * FROM AsteroidEntity obj WHERE obj.closeApproachDate = :today"
}