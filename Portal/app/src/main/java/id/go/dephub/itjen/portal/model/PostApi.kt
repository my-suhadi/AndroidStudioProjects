package id.go.dephub.itjen.portal.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PostApi {
    @GET("wp-json/wp/v2/posts/")
    fun getAllPosts(): Single<List<PostModel>>
}