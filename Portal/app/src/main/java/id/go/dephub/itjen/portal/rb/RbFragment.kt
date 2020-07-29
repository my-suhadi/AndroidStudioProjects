package id.go.dephub.itjen.portal.rb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.rb.model.RbModel
import kotlinx.android.synthetic.main.fragment_rb.*

class RbFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rb, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val dataPostRb = listOf(
            RbModel("Delapan Area Perubahan", "https://itjen.dephub.go.id/delapan-area-perubahan/"),
            RbModel("Index Reformasi Birokrasi", "https://itjen.dephub.go.id/index-reformasi-birokrasi/"),
            RbModel("Timeline", "https://itjen.dephub.go.id/timeline/"),
            RbModel("Dokumentasi", "https://itjen.dephub.go.id/dokumentasi/")
        )

        rv_reformasi_birokrasi.layoutManager = LinearLayoutManager(requireContext())
        rv_reformasi_birokrasi.adapter = RbAdapter(dataPostRb, requireContext(), requireView())
    }
}