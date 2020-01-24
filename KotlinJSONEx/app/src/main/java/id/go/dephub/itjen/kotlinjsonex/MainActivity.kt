// https://www.youtube.com/watch?v=kPQ2jtWe2gw

package id.go.dephub.itjen.kotlinjsonex

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import dmax.dialog.SpotsDialog
import id.go.dephub.itjen.kotlinjsonex.adapter.MyMovieAdapter
import id.go.dephub.itjen.kotlinjsonex.antarmuka.RetrofitService
import id.go.dephub.itjen.kotlinjsonex.common.Common
import id.go.dephub.itjen.kotlinjsonex.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        rvMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        rvMovieList.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()
    }

    private fun getAllMovieList() {
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<Movie>>, response: Response<MutableList<Movie>>) {
                adapter = MyMovieAdapter(baseContext, response.body() as MutableList<Movie>)
                adapter.notifyDataSetChanged()
                rvMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}
