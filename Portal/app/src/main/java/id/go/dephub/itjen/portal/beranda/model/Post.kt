package id.go.dephub.itjen.portal.beranda.model


import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("categories")
    val categories: List<Int>,
    @SerializedName("content")
    val content: Content,
    @SerializedName("date")
    val date: String,
    @SerializedName("featured_media")
    val featuredMedia: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("title")
    val title: Title
)