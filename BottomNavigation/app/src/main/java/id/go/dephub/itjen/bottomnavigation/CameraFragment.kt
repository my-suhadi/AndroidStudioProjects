package id.go.dephub.itjen.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_camera.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
class CameraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPhotos.setOnClickListener {
            val random = Random(100)

            val nextAction = CameraFragmentDirections.actionDestinationCameraToDestinationPhotos()
            nextAction.setNumberOfPhotos(random.nextInt(100))

            Navigation.findNavController(it).navigate(nextAction)
        }
    }
}
