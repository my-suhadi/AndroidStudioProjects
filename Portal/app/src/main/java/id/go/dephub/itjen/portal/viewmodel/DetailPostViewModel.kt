package id.go.dephub.itjen.portal.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import id.go.dephub.itjen.portal.model.PostDatabase
import id.go.dephub.itjen.portal.model.PostModel
import id.go.dephub.itjen.portal.util.SharedPreferencesHelper
import kotlinx.coroutines.launch

class DetailPostViewModel(_app: Application) : BaseViewModel(_app) {   // parameter dan pewarisannya harus sama dengan PostListViewModel
    internal val postLiveData = MutableLiveData<PostModel>()

    internal fun fetch(postId: Int) {
        launch {
            val post = PostDatabase.invoke(getApplication()).postDao().getPost(postId)
            postLiveData.value = post
        }
        SharedPreferencesHelper(getApplication()).savedUpdateTime(System.nanoTime())
    }
}