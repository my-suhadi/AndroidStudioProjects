package id.go.dephub.itjen.portal.beranda.model.media


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val id: Int,
    @SerializedName("media_details")
    val mediaDetails: MediaDetails,
    @SerializedName("post")
    val post: Int,
    @SerializedName("source_url")
    val sourceUrl: String
)