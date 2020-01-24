package id.go.dephub.itjen.dailyshalattime.model

import com.google.gson.annotations.SerializedName

data class TodayWeather(
    @SerializedName("temperature")
    val temperature: String = "",
    @SerializedName("pressure")
    val pressure: String = ""
)