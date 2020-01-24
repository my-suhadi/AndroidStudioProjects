package id.go.dephub.itjen.dailyshalattime.model

import com.google.gson.annotations.SerializedName

data class Solat(
    @SerializedName("country")
    val country: String = "",
    @SerializedName("status_description")
    val statusDescription: String = "",
    @SerializedName("address")
    val address: String = "",
    @SerializedName("status_code")
    val statusCode: Int = 0,
    @SerializedName("method")
    val method: Int = 0,
    @SerializedName("prayer_method_name")
    val prayerMethodName: String = "",
    @SerializedName("city")
    val city: String = "",
    @SerializedName("timezone")
    val timezone: String = "",
    @SerializedName("query")
    val query: String = "",
    @SerializedName("latitude")
    val latitude: String = "",
    @SerializedName("for")
    val forX: String = "",
    @SerializedName("link")
    val link: String = "",
    @SerializedName("qibla_direction")
    val qiblaDirection: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("status_valid")
    val statusValid: Int = 0,
    @SerializedName("sealevel")
    val sealevel: String = "",
    @SerializedName("country_code")
    val countryCode: String = "",
    @SerializedName("daylight")
    val daylight: String = "",
    @SerializedName("today_weather")
    val todayWeather: TodayWeather,
    @SerializedName("state")
    val state: String = "",
    @SerializedName("postal_code")
    val postalCode: String = "",
    @SerializedName("items")
    val items: List<Item>?,
    @SerializedName("map_image")
    val mapImage: String = "",
    @SerializedName("longitude")
    val longitude: String = ""
)