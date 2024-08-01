package mo.ed.nozha.apps.excercise.seight.intents

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.seight.models.Trip

class EndingActivity : AppCompatActivity() {
    lateinit var userNameTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ending)

        userNameTv = findViewById(R.id.tvUserName)

        // intent approach
//        val userName = intent.getStringExtra("USER_NAME")
//        val age = intent.getIntExtra("AGE", 0)
//        val isYoung = intent.getBooleanExtra("IS_YOUNG", false)

        //bundle approach
//        val userName = intent.extras?.getString("USER_NAME")
//        val age = intent.extras?.getInt("AGE")
//        val isYoung = intent.extras?.getBoolean("IS_YOUNG")

//        userNameTv.text = " UserName: $userName,\n"+
//                "Age: $age \n"+
//                "Is Young: $isYoung"

        val trip = intent.getSerializableExtra("trip") as Trip

        userNameTv.text = "Trip Id: ${trip.id}\n" +
                "Pickup: ${trip.pickupAddress}\n"+
                "Destination: ${trip.destination}"
    }
}