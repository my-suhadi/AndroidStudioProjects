package id.go.dephub.itjen.portal.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PostModel(
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

    /*
    @SerializedName("link") -> nama variabel json d remote (harus sama)
    @ColumnInfo(name = "post_link") -> untuk memberi nama kolom di database (defaultnya = remote)
    internal val link: String -> nama variabel yg akan dgunakan dalam instan (defaultnya = remote)
    */
    @SerializedName("link")
    @ColumnInfo(name = "post_link")
    val link: String,

    @SerializedName("title")
    val title: Title
) {
    @PrimaryKey(autoGenerate = true)
    var postId: Int = 0
}