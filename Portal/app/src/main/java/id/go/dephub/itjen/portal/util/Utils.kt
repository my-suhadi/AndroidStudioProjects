package id.go.dephub.itjen.portal.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
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

internal fun ImageView.loadImage(url: String, progressDrawable: CircularProgressDrawable) {
    val opt = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_trimatra)

    Glide.with(context)
        .setDefaultRequestOptions(opt)
        .load(url)
        .into(this)
}

@BindingAdapter("android:imgUrl")
internal fun loadImg(v: ImageView, url: String) {
    v.loadImage(url, getProgressDrawable(v.context))
}