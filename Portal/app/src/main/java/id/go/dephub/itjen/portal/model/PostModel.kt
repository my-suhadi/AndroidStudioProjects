package id.go.dephub.itjen.portal.model

import com.google.gson.annotations.SerializedName

data class PostModel(
    @SerializedName("categories")
    internal val categories: List<Int>,

    @SerializedName("content")
    internal val content: Content,

    @SerializedName("date")
    internal val date: String,

    @SerializedName("featured_media")
    internal val featuredMedia: Int,

    @SerializedName("id")
    internal val id: Int,

    @SerializedName("link")
    internal val link: String,

    @SerializedName("title")
    internal val title: Title
)