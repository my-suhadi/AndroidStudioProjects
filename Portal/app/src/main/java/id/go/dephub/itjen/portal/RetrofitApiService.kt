package id.go.dephub.itjen.portal

import id.go.dephub.itjen.portal.beranda.model.media.Image
import id.go.dephub.itjen.portal.beranda.model.Post
import id.go.dephub.itjen.portal.buletin.model.Menu
import id.go.dephub.itjen.portal.rb.model.RbMenu
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
        fun create() : RetrofitApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://itjen.dephub.go.id/wp-json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(RetrofitApiService::class.java)
        }
    }
}