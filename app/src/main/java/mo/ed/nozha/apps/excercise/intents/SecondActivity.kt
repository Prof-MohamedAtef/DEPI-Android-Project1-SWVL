package mo.ed.nozha.apps.excercise.intents

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.models.Order

class SecondActivity : AppCompatActivity() {
    lateinit var textViewName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        /*
        Bundle
        //        val receivedText = intent.extras?.getString("name")
         */
        /*
        Intent
         */
        val name = intent.getStringExtra("name")
        val age = intent.getIntExtra("age", 0)
        val isLong = intent.getBooleanExtra("isLong", false)
        val order = intent.extras?.getSerializable("order") as Order

        textViewName = findViewById(R.id.tvName)
        textViewName.text = "name: $name, age: $age, isLong? $isLong\n"+
                "orderId: ${order.id}, \norder name: ${order.name}, \n"+
                "orderTime: ${order.time}"


    }
}