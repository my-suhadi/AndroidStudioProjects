package id.go.dephub.itjen.dailyshalattime.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("asr")
    val asr: String = "",
    @SerializedName("isha")
    val isha: String = "",
    @SerializedName("shurooq")
    val shurooq: String = "",
    @SerializedName("date_for")
    val dateFor: String = "",
    @SerializedName("dhuhr")
    val dhuhr: String = "",
    @SerializedName("fajr")
    val fajr: String = "",
    @SerializedName("maghrib")
    val maghrib: String = ""
)