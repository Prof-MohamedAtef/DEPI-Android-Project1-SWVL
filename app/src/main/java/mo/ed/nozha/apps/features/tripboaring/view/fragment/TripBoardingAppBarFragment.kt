package mo.ed.nozha.apps.features.tripboaring.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mo.ed.nozha.apps.R
import mo.ed.nozha.apps.features.tripboaring.view.activity.TripBoardingActivity

class TripBoardingAppBarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_layout, container, false)
    }
}