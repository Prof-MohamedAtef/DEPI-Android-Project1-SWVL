package mo.ed.nozha.apps.excercise.seight.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R

class StartingActivity : AppCompatActivity() {
    /*
    inflate layout
     */
    lateinit var nameEditText: EditText
    lateinit var btnSendData: Button
    lateinit var ageEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_starting)
        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        btnSendData = findViewById(R.id.btn_send_data)


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
            bundle.putString("USER_NAME", username.toString())
            bundle.putInt("AGE", age.toString().toInt())
            bundle.putBoolean("IS_YOUNG", true)
            intent.putExtras(bundle)
            startActivity(intent)
        }


    }
}