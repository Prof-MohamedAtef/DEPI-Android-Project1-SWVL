package mo.ed.nozha.apps.excercise.snine.intents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.snine.models.Order

/*
Thursday, 1 August, 2024
 */
class FirstActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var ageEditText: EditText
    lateinit var btnSendDate: Button
    lateinit var mapLauncher: ImageView
    lateinit var editPhone: EditText
    lateinit var callLauncher: ConstraintLayout
    lateinit var smsLauncher: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        /*
        inflate
         */
        nameEditText = findViewById(R.id.editText)
        ageEditText = findViewById(R.id.age_editText)
        btnSendDate = findViewById(R.id.btnSendData)
        mapLauncher = findViewById(R.id.map_launcher)
        editPhone = findViewById(R.id.editPhone)
        callLauncher = findViewById(R.id.call_launcher)
        smsLauncher = findViewById(R.id.sms_launcher)

        btnSendDate.setOnClickListener { view ->
            var name = nameEditText.text
            var age = ageEditText.text


            /*
            using Intent
             */

            val nameIntent = Intent(this@FirstActivity, SecondActivity::class.java).apply {
                putExtra("name", name.toString())
//                putExtra("age", age.toString())
                putExtra("isLong", true)
                putExtra("age", 30)

//                putExtra()
            }

            /*
            using Bundle
             */
            val bundle = Bundle()
//            bundle.putString("name", name.toString())
//            nameIntent.putExtras(bundle)
            val order = Order(id = 5, "Mohamed", "Morning")
            bundle.putSerializable("order", order)
            nameIntent.putExtras(bundle)

            startActivity(nameIntent)
        }

        mapLauncher.setOnClickListener { view->
//            31.18739267593117, 29.897400153896665
            val latitude =  31.18739267593117
            val longitude = 29.897400153896665
            val uri = Uri.parse("geo:$latitude,$longitude")
            val mapIntent = Intent(Intent.ACTION_VIEW, uri)
            mapIntent.setPackage("com.google.android.apps.maps")

            startActivity(mapIntent)

        }

        callLauncher.setOnClickListener { view->
            var phone = editPhone.text
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",phone.toString(), null))
            startActivity(intent)
        }

        smsLauncher.setOnClickListener { view->
            var phone = editPhone.text
            val intent = Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",phone.toString(), null))
            startActivity(intent)
        }

        Log.e("OnCreate:", "App has been created")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart:", "App has just started")
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResumse", "App has been resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.e("onPause", "App has been paused")
    }

    override fun onStop() {
        super.onStop()
        Log.e("onStop", "App has Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "App has destroyed")
    }
}