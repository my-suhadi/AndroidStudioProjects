package id.go.dephub.itjen.kotlinjsonex.common

import id.go.dephub.itjen.kotlinjsonex.antarmuka.RetrofitService
import id.go.dephub.itjen.kotlinjsonex.retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://simplifiedcoding.net/demos/"

    var retrofitService: RetrofitService
        get() {
            return RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
        }
        set(value) {}
}