package mo.ed.nozha.apps.excercise.intents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.models.Order

/*
Thursday, 1 August, 2024
 */
class FirstActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var ageEditText: EditText
    lateinit var btnSendDate: Button
    lateinit var mapLauncher: ImageView
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


    }
}