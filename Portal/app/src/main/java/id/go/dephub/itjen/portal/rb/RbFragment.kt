package id.go.dephub.itjen.portal.rb

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.RetrofitApiService
import id.go.dephub.itjen.portal.rb.model.RbMenu
import id.go.dephub.itjen.portal.rb.model.RbModel
import kotlinx.android.synthetic.main.fragment_rb.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        // buat servis retrofit baru
        val serviceRetro = RetrofitApiService.create(requireContext())

        // ambil data json dr menu reformasi birokrasi menggunakan menu_parent_id = 2799
        serviceRetro.getRbMenuList().enqueue(object : Callback<List<RbMenu>> {
            override fun onFailure(call: Call<List<RbMenu>>, t: Throwable) {
                Log.d("RbFragment", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<List<RbMenu>>, response: Response<List<RbMenu>>) {
                val listOfRbPost = mutableListOf<RbModel>()
                val j = response.body()!!.size - 1

                for (i in 0..j) {
                    if (response.body()!![i].menuItemParent == "2799") {
                        listOfRbPost.add(RbModel(response.body()!![i].title, response.body()!![i].url))
                    }
                }

                rv_reformasi_birokrasi.adapter = RbAdapter(listOfRbPost, requireContext(), requireView())
            }
        })
/*

        val dataPostRb = listOf(
            RbModel("Delapan Area Perubahan", "https://itjen.dephub.go.id/delapan-area-perubahan/"),
            RbModel("Index Reformasi Birokrasi", "https://itjen.dephub.go.id/index-reformasi-birokrasi/"),
            RbModel("Timeline", "https://itjen.dephub.go.id/timeline/"),
            RbModel("Dokumentasi", "https://itjen.dephub.go.id/dokumentasi/")
        )
*/
        rv_reformasi_birokrasi.layoutManager = LinearLayoutManager(requireContext())
    }
}