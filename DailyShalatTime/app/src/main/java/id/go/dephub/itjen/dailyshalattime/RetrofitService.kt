package id.go.dephub.itjen.dailyshalattime

import id.go.dephub.itjen.dailyshalattime.model.Solat
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{city}.json?key=abb7f0b1690ca9935000a01621e3dbc2")
    fun getApi(@Path("city") city: String): Call<Solat>

    companion object {
        fun create(): RetrofitService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://muslimsalat.com")
                .build()
            return retrofit.create(RetrofitService::class.java)
        }
    }
}