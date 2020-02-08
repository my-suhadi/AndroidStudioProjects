package id.go.dephub.itjen.portal.struktur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import id.go.dephub.itjen.portal.R

class StrukturFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.struktur_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.btItjen).setOnClickListener(this)
        view.findViewById<Button>(R.id.btSetitjen).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var strukturUrl = when (v!!.id) {
            R.id.btItjen -> "https://itjen.dephub.go.id/wp-content/uploads/2020/01/struktur-org-1024x724.jpg"
            R.id.btSetitjen-> "https://itjen.dephub.go.id/wp-content/uploads/2020/01/struktur-org-Sesit-1024x724.jpg"
            else -> null
        }
        val bundle = bundleOf("strukturUrl" to strukturUrl)
        navController.navigate(R.id.action_nav_struktur_to_detailStruktur, bundle)
    }
}