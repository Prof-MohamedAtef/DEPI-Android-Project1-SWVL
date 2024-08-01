package mo.ed.nozha.apps.excercise.seight.intents

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R

class EndingActivity : AppCompatActivity() {
    lateinit var userNameTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ending)

        userNameTv = findViewById(R.id.tvUserName)

        val userName = intent.getStringExtra("USER_NAME")
        val age = intent.getIntExtra("AGE", 0)
        val isYoung = intent.getBooleanExtra("IS_YOUNG", false)

        userNameTv.text = " UserName: $userName,\n"+
                "Age: $age \n"+
                "Is Young: $isYoung"

    }
}