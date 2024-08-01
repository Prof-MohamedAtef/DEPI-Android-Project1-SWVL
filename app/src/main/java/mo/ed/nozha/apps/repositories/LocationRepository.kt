package mo.ed.nozha.apps.repositories

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener

class LocationRepository(context: Context) {
    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    private val _locationData = MutableLiveData<Pair<Double, Double>>()
    val locationData: LiveData<Pair<Double, Double>> = _locationData


    @SuppressLint("MissingPermission")
    fun updateLocation(){
        fusedLocationClient.lastLocation.addOnSuccessListener(OnSuccessListener { location->
            if (location != null){
                _locationData.value = Pair(location.latitude, location.longitude)
            }
        })
    }

}