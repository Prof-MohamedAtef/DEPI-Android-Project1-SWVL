package mo.ed.nozha.apps.excercise.intents

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
/*
Thursday, 1 August, 2024
 */
class FirstActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var btnSendDate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)
        /*
        inflate
         */
        nameEditText = findViewById(R.id.editText)
        btnSendDate = findViewById(R.id.btnSendData)

        btnSendDate.setOnClickListener { view->
            var name = nameEditText.text

        }
    }
}