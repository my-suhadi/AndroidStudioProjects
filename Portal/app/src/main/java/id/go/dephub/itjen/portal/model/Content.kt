package id.go.dephub.itjen.portal.model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("protected")
    internal val protected: Boolean,

    @SerializedName("rendered")
    internal val rendered: String
)