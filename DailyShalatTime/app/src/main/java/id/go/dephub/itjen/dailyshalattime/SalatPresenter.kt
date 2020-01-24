package id.go.dephub.itjen.dailyshalattime

import android.content.Context
import id.go.dephub.itjen.dailyshalattime.model.Item
import id.go.dephub.itjen.dailyshalattime.model.Solat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SalatPresenter(context: Context) {
    val salatView = context as ISalatView

    fun getDataFromApi(city: String) {
        RetrofitService.create()
            .getApi(city)
            .enqueue(object: Callback<Solat> {
                override fun onFailure(call: Call<Solat>, t: Throwable) {
                    salatView.onDataErrorFromApi(t)
                }

                override fun onResponse(call: Call<Solat>, response: Response<Solat>) {
                    salatView.onDataCompleteFromApi(response.body()?.items?.get(0) as Item)
                }

            })
    }
}