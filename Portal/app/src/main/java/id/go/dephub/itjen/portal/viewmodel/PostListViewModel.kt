package id.go.dephub.itjen.portal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.go.dephub.itjen.portal.model.PostModel

class PostListViewModel : ViewModel() {
    internal val allPosts = MutableLiveData<List<PostModel>>()
    internal val postLoadError = MutableLiveData<Boolean>()
    internal val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val postTestForRefresh1 = PostModel("Judul 1", "Test url 1")
        val postTestForRefresh2 = PostModel("Judul 2", "Test url 2")
        val postTestForRefresh3 = PostModel("Judul 3", "Test url 3")

        val postList = arrayListOf<PostModel>(postTestForRefresh1, postTestForRefresh2, postTestForRefresh3)

        allPosts.value = postList
        postLoadError.value = false
        loading.value = false
    }
}