package mo.ed.nozha.apps.features.tripboaring.view.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.Utils
import mo.ed.nozha.apps.features.tripboaring.view.fragment.AllLayoutFragment
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
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.boarding_pass_frame_id, tripBoardingAppBarFragment)
                .commitAllowingStateLoss()
        }


//        val tripId = intent.getStringExtra(Utils.TRIP_ID_KEY)

//        val tripId = intent.extras?.getString(Utils.TRIP_ID_KEY)
//        Log.e("TripID: ", tripId.toString())


//        val allLayoutFragment = AllLayoutFragment()

//            supportFragmentManager.beginTransaction()
//                .add(R.id.all_layout_frame_id, allLayoutFragment)
//                .commitAllowingStateLoss()
//        }
    }
}