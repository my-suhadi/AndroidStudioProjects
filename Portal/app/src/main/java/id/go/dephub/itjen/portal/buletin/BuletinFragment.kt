/*
https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin
1. Declare the RecyclerView in an activity layout and reference it in the activity Kotlin file.
2. Create a custom item XML layout for RecyclerView for its items.
3. Create the view holder for view items, connect the data source of the RecyclerView and handle the view logic by creating a RecyclerView Adapter.
4. Attach the adapter to the RecyclerView.
*/

package id.go.dephub.itjen.portal.buletin

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.RetrofitApiService
import id.go.dephub.itjen.portal.buletin.model.Buletin
import id.go.dephub.itjen.portal.buletin.model.Menu
import kotlinx.android.synthetic.main.buletin_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuletinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.buletin_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rvBuletin.layoutManager = GridLayoutManager(activity, 3)

        RetrofitApiService.create(requireContext()).getMenuList().enqueue(object : Callback<List<Menu>> {
            override fun onFailure(call: Call<List<Menu>>, t: Throwable) {
                d("BuletinFragment", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<List<Menu>>, response: Response<List<Menu>>) {
                val listOfBuletin = mutableListOf<Buletin>()
                val j = response.body()!!.size - 1

                for (i in 0..j) {
                    if (response.body()!![i].menuItemParent == "1602") {
                        listOfBuletin.add(Buletin(response.body()!![i].title, response.body()!![i].url))
                    }
                }

                rvBuletin.adapter = BuletinAdapter(listOfBuletin, object : BuletinAdapter.OnClickListener {
                    override fun onItemClick(buletinUrl: String) {
                        val bundle = bundleOf("buletinUrl" to buletinUrl)
                        Navigation.findNavController(view!!).navigate(R.id.action_nav_buletin_to_buletin_viewer, bundle)
                        d("BuletinFragment", "onItemClicked: $buletinUrl")
                    }
                })
            }
        })
    }
/*

    private fun generateSampleData(): List<Buletin>{
        return listOf(
            Buletin(
                "Vol.13 Nomor 1 Tahun 2018",
                "https://itjen.dephub.go.id/wp-content/uploads/Buletin/Transparansi-2018_01.pdf"
            ),
            Buletin(
                "Vol.14 Nomor 2 Tahun 2018",
                "https://itjen.dephub.go.id/wp-content/uploads/Buletin/Transparansi-2018_02.pdf"
            ),
            Buletin(
                "Vol.15 Nomor 3 Tahun 2018",
                "https://itjen.dephub.go.id/wp-content/uploads/Buletin/Transparansi-2018_03.pdf"
            ),
            Buletin(
                "Vol.16 Nomor 4 Tahun 2018",
                "https://itjen.dephub.go.id/wp-content/uploads/Buletin/Transparansi-2018_04.pdf"
            )
        )
    }
*/
}