package id.go.dephub.itjen.kotlinjsonex.antarmuka

import id.go.dephub.itjen.kotlinjsonex.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("marvel")
    fun getMovieList() : Call<MutableList<Movie>>
}