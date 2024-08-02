package mo.ed.nozha.apps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.features.tripboaring.view.activity.TripBoardingActivity

class TripDetails : AppCompatActivity() {
    lateinit var editTripId: EditText
    lateinit var btnSendData: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trip_details)
        editTripId = findViewById(R.id.editTripId)

        btnSendData = findViewById(R.id.btnSendData)

        btnSendData.setOnClickListener { view ->
            var tripId = editTripId.text

            val bundle = Bundle()
            bundle.putString(Utils.TRIP_ID_KEY, tripId.toString())
            val intent = Intent(this, TripBoardingActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }


    }
}