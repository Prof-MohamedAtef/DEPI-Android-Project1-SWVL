package mo.ed.nozha.apps.features.location.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import mo.ed.nozha.apps.repositories.LocationRepository

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val locationRepository: LocationRepository = LocationRepository(application)

    val locationData: LiveData<Pair<Double, Double>> = locationRepository.locationData

    fun updateLocation(){
        locationRepository.updateLocation()
    }
}