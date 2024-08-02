package mo.ed.nozha.apps.excercise.seight.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.seight.models.Trip

class StartingActivity : AppCompatActivity() {
    /*
    inflate layout
     */
    lateinit var nameEditText: EditText
    lateinit var btnSendData: Button
    lateinit var ageEditText: EditText
    lateinit var mapLauncher: ConstraintLayout
    lateinit var callLauncher: ConstraintLayout
    lateinit var smsLauncher: ConstraintLayout
    lateinit var friendEditPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starting)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        btnSendData = findViewById(R.id.btn_send_data)
        mapLauncher = findViewById(R.id.mapLauncher)
        callLauncher = findViewById(R.id.callIntentLauncher)
        friendEditPhone = findViewById(R.id.friendEditPhone)
        smsLauncher = findViewById(R.id.smsIntentLauncher)


        btnSendData.setOnClickListener { view->
            var username = nameEditText.text
            var age = ageEditText.text
            /*
            intent - explicit / implicit
             */
            val intent = Intent(this, EndingActivity::class.java)
//                .apply {
//                putExtra("USER_NAME", username.toString()) // String
//                putExtra("AGE", age.toString().toInt())
//                putExtra("IS_YOUNG", true)
//            }


            /*
            bundle
             */
            val bundle = Bundle()
//            bundle.putString("USER_NAME", username.toString())
//            bundle.putInt("AGE", age.toString().toInt())
//            bundle.putBoolean("IS_YOUNG", true)

            /*
            using Serializable
             */
            val trip = Trip(8585, "El-Arish", "Cairo")
            bundle.putSerializable("trip", trip)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        /*
        implicit intent
         */

        //30.129448506052125, 31.372985382219905
        mapLauncher.setOnClickListener { view->
            val latitude = 30.129448506052125
            val longitude = 31.372985382219905
            val uri = Uri.parse("geo:$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }

        /*
        phone call implicit intent
         */

        callLauncher.setOnClickListener { view->
            val phone = friendEditPhone.text
            val phoneIntent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phone.toString(), null))
            startActivity(phoneIntent)
        }

        /*
        messaging implicit intent
         */

        smsLauncher.setOnClickListener { view->
            val phone = friendEditPhone.text
            val phoneIntent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",phone.toString(), null))
            startActivity(phoneIntent)
        }

    }
}