package id.go.dephub.itjen.portal.buletin.model


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("ID")
    val iD: Int,
    @SerializedName("menu_item_parent")
    val menuItemParent: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)