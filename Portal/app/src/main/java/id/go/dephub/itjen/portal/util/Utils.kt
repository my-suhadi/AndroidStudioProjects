package id.go.dephub.itjen.portal.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.go.dephub.itjen.portal.R

internal fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 30f
        start()
    }
}

internal fun ImageView.loadImage(uri: String, progressDrawable: CircularProgressDrawable) {
    val opt = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_trimatra)

    Glide.with(context)
        .setDefaultRequestOptions(opt)
        .load(uri)
        .into(this)
}