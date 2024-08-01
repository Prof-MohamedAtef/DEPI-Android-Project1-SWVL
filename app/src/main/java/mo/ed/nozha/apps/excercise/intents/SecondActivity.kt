package mo.ed.nozha.apps.excercise.intents

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R

class SecondActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        val intent = intent
        val name = intent.getStringExtra("NAME_KEY")
        textViewName = findViewById(R.id.tvName)
        textViewName.text = name
    }
}