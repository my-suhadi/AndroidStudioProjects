package id.go.dephub.itjen.portal.beranda

import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.RetrofitApiService
import id.go.dephub.itjen.portal.beranda.model.Post
import kotlinx.android.synthetic.main.home_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*
        cara penggunaan recyclerview
        https://guides.codepath.com/android/Using-the-RecyclerView#using-the-recyclerviewval
        gabungin recyclerview dg fragment
        https://www.youtube.com/watch?v=0aOn2mIRlCA
        */

        /*
        penggunaan retrofit dengan recyclerview
        https://www.youtube.com/watch?v=FiqiIJNALFs
        1 : val retrofit
        2 : buat interface RetrofitApiService
        3 : val api
        4 : api.getAllPosts()
        */

        RetrofitApiService.create().getAllPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                d("onActivityCreated", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                showData(response.body()!!)
            }
        })
    }

    private fun showData(posts: List<Post>) {
        rvBeranda.adapter = HomeAdapter(posts, object : HomeAdapter.OnClickListener {
            override fun onItemClick(postLink: String) {
                val bundle = bundleOf("postLink" to  postLink)
                Navigation.findNavController(view!!).navigate(R.id.action_nav_beranda_to_detail_post, bundle)
            }
        })

        rvBeranda.layoutManager = LinearLayoutManager(activity)
    }
}