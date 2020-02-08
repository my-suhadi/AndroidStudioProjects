package id.go.dephub.itjen.portal.struktur


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import id.go.dephub.itjen.portal.R
import kotlinx.android.synthetic.main.fragment_detail_struktur.*
import kotlinx.android.synthetic.main.fragment_detail_struktur.view.*
import kotlinx.android.synthetic.main.item_buletin.view.*

/**
 * A simple [Fragment] subclass.
 */
class DetailStruktur : Fragment() {

    lateinit var strukturUrl: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_struktur, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        strukturUrl = arguments!!.getString("strukturUrl")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view.context).load(strukturUrl)
            .into(view.ivStruktur)
    }
}
