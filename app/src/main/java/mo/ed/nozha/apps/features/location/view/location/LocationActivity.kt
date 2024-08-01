package mo.ed.nozha.apps.features.location.view.location

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.features.location.viewmodel.LocationViewModel

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {
    private val locationViewModel: LocationViewModel by viewModels()
    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_location)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (!hasLocationPermission()) {
            requestLocationPermission()
        } else {
            observeLocationUpdates()
            locationViewModel.updateLocation()
        }

        // Initialize the map
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestLocationPermission() {
        requestPermissionLauncher.launch(
            arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permisions ->
            if (permisions[android.Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permisions[android.Manifest.permission.ACCESS_COARSE_LOCATION] == true
            ) {
                observeLocationUpdates()
                locationViewModel.updateLocation()
            }
        }

    private fun observeLocationUpdates() {
        locationViewModel.locationData.observe(this, Observer { location ->
            val (latitude, longitude) = location
            Log.e("Location", "latitude: $latitude, and longitude: $longitude")
            val latLong = LatLng(latitude, longitude)
            map.addMarker(MarkerOptions().position(latLong).title("Current Location"))
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLong, 15f))
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
    }

}