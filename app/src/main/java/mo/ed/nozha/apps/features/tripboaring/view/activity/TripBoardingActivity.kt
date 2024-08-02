package mo.ed.nozha.apps.features.tripboaring.view.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.features.tripboaring.view.fragment.TripBoardingAppBarFragment

// android application components
/*
Activity
 */
class TripBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val tripBoardingAppBarFragment = TripBoardingAppBarFragment()

        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.boarding_pass_frame_id, tripBoardingAppBarFragment)
                .commitAllowingStateLoss()

        }
    }
}