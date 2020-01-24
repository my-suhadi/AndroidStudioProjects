package id.go.dephub.itjen.portal.beranda.model.media


import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("file")
    val `file`: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mime_type")
    val mimeType: String,
    @SerializedName("source_url")
    val sourceUrl: String,
    @SerializedName("width")
    val width: Int
)