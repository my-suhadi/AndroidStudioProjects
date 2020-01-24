package id.go.dephub.itjen.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_photos.*

/**
 * A simple [Fragment] subclass.
 */
class PhotosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnHome.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_destination_photos_to_destination_home)
        }

        arguments?.let {
            val safeArgs = PhotosFragmentArgs.fromBundle(it)
            tvNumber.text = "Number or photos: ${safeArgs.numberOfPhotos}"
        }
    }
}