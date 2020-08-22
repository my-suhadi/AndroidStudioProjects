package id.go.dephub.itjen.portal.model


import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("source_url")
    val imageUrl: String
)