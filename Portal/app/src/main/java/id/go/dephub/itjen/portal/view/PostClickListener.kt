package id.go.dephub.itjen.portal.view

import android.view.View

interface PostClickListener {
    fun onPostClicked(v:View, postId: Int)
}