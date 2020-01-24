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
import androidx.recyclerview.widget.LinearLayoutManager

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
        rvBuletin.layoutManager = LinearLayoutManager(activity)

        RetrofitApiService.create().getMenuList().enqueue(object : Callback<Menu> {
            override fun onFailure(call: Call<Menu>, t: Throwable) {
                d("BuletinFragment", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Menu>, response: Response<Menu>) {
                val listOfBuletin = mutableListOf<Buletin>()

                d("BuletinFragment", "onResponse: ${response.body()!!.menuItemParent}")
            }
        })

        rvBuletin.adapter = BuletinAdapter(generateSampleData())
    }

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
}