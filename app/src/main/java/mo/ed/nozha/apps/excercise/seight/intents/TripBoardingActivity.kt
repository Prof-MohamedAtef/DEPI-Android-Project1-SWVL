package mo.ed.nozha.apps.excercise.seight.intents

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.excercise.seight.fragments.BlueFragment
import mo.ed.nozha.apps.excercise.seight.fragments.OnBoardingPassFragment

class TripBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_trip_boarding)

        val onBoardingPassFragment = OnBoardingPassFragment()
        val blueFragment = BlueFragment()

        supportFragmentManager.beginTransaction().add(R.id.appbar_frame_id, onBoardingPassFragment)
            .commitAllowingStateLoss()

        supportFragmentManager.beginTransaction().add(R.id.blue_frame, blueFragment)
            .commitAllowingStateLoss()

    }
}