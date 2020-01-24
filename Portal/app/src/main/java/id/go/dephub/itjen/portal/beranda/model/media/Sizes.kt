package id.go.dephub.itjen.portal.beranda.model.media


import com.google.gson.annotations.SerializedName

data class Sizes(
    @SerializedName("full")
    val full: Full,
    @SerializedName("medium")
    val medium: Medium,
    @SerializedName("medium_large")
    val mediumLarge: MediumLarge,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail
)