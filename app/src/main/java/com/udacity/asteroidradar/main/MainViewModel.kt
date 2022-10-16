package com.udacity.asteroidradar.main

import android.app.Application
import androidx.lifecycle.*
import com.udacity.asteroidradar.database.AsteroidRadarDatabase
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.network.AsteroidApiFilter
import com.udacity.asteroidradar.repository.AsteroidsRepository
import com.udacity.asteroidradar.repository.PicturesOfDayRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val database = AsteroidRadarDatabase.getDatabase(application)
    private val filter = MutableLiveData(AsteroidApiFilter.SHOW_SAVED)
    private val picturesOfDayRepository = PicturesOfDayRepository(database)
    private val asteroidsRepository = AsteroidsRepository(database)

    init {
        viewModelScope.launch {
            picturesOfDayRepository.refreshPictureOfDay()
            asteroidsRepository.refreshAsteroids()
        }
    }

    val picOfDay = picturesOfDayRepository.pictureOfDay
    val asteroids = Transformations.switchMap(filter) {
        when (it) {
            AsteroidApiFilter.SHOW_TODAY -> asteroidsRepository.asteroidsToday
            AsteroidApiFilter.SHOW_WEEK -> asteroidsRepository.asteroidsWeek
            else -> asteroidsRepository.asteroidsSaved
        }
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    private val _navigateToSelectedAsteroid = MutableLiveData<Asteroid?>()

    val navigateToSelectedProperty: MutableLiveData<Asteroid?>
        get() = _navigateToSelectedAsteroid


    fun displayAsteroidDetails(asteroid: Asteroid) {
        _navigateToSelectedAsteroid.value = asteroid
    }


    fun displayAsteroidDetailsComplete() {
        _navigateToSelectedAsteroid.value = null
    }

    fun updateFilter(filter: AsteroidApiFilter) {
        this.filter.value = filter
    }

}