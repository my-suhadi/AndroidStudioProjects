package id.go.dephub.itjen.portal

import android.content.Context
import android.net.ConnectivityManager
import id.go.dephub.itjen.portal.beranda.model.Post
import id.go.dephub.itjen.portal.beranda.model.media.Image
import id.go.dephub.itjen.portal.buletin.model.Menu
import id.go.dephub.itjen.portal.rb.model.RbMenu
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApiService {
    @GET("wp/v2/posts/?per_page=100")
    fun getAllPosts(): Call<List<Post>>
    @GET("wp/v2/media/{id}")
    fun getImage(@Path("id") id : Int ): Call<Image>
    // menu_item_parent utk transparansi adl 1602
    // menu_item_parent utk rb adl 2799
    @GET("menus/v1/menus/3")
    fun getMenuList(): Call<List<Menu>>
    @GET("menus/v1/menus/3")
    fun getRbMenuList(): Call<List<RbMenu>>

    companion object {
        fun create(cx: Context) : RetrofitApiService {
            val cacheSize = (5 * 1024 * 1024).toLong()  // menentukan ukuran cache sebesar 5MB
            val myCache = Cache(cx.cacheDir, cacheSize)

            val okClient = OkHttpClient.Builder()
                .cache(myCache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (hasNetwork(cx)!!)
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    else
                        request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                    chain.proceed(request)
                }
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://itjen.dephub.go.id/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okClient)
                .build()
            return retrofit.create(RetrofitApiService::class.java)
        }

        private fun hasNetwork(cx: Context): Boolean? {
            var isConnected: Boolean? = false // Initial Value
            val connectivityManager = cx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = connectivityManager.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected)
                isConnected = true
            return isConnected
        }
    }
}