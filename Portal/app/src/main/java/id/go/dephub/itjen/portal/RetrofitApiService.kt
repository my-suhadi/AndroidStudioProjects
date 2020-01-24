package id.go.dephub.itjen.portal

import id.go.dephub.itjen.portal.beranda.model.media.Image
import id.go.dephub.itjen.portal.beranda.model.Post
import id.go.dephub.itjen.portal.buletin.model.Menu
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitApiService {
    @GET("wp/v2/posts")
    fun getAllPosts(): Call<List<Post>>
    @GET("wp/v2/media/{id}")
    fun getImage(@Path("id") id : Int ): Call<Image>
    // menu_item_parent utk transparansi adl 1602
    @GET("menus/v1/menus/3")
    fun getMenuList(): Call<Menu>

    companion object {
        fun create() : RetrofitApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://itjen.dephub.go.id/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitApiService::class.java)
        }
    }
}