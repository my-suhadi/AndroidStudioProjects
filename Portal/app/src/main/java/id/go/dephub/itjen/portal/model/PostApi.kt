package id.go.dephub.itjen.portal.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PostApi {
    @GET("wp-json/wp/v2/posts/")
    fun getAllPosts(): Single<List<PostModel>>
    @GET("wp-json/wp/v2/media/{id}")
    fun getImage(@Path("id") id : Int ): Single<ImageModel>
}