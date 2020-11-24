package id.go.dephub.itjen.portal.model

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiService {
    private val BASE_URL = "https://itjen.dephub.go.id/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(PostApi::class.java)

    internal fun getAllPost(): Single<List<PostModel>> {
        return api.getAllPosts()
    }
}