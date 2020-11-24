package id.go.dephub.itjen.portal.model

import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("rendered")
    val text: String
)