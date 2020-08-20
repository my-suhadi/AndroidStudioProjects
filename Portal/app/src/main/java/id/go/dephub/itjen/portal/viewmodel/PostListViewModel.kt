package id.go.dephub.itjen.portal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.go.dephub.itjen.portal.model.PostModel
import id.go.dephub.itjen.portal.model.RetrofitApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PostListViewModel : ViewModel() {

    private val postApiService = RetrofitApiService()
    private val disposablePost = CompositeDisposable()

    internal val allPosts = MutableLiveData<List<PostModel>>()
    internal val postLoadError = MutableLiveData<Boolean>()
    internal val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposablePost.add(
            postApiService.getAllPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<PostModel>>() {
                    override fun onSuccess(value: List<PostModel>?) {
                        allPosts.value = value
                        postLoadError.value = false
                        loading.value = false
                    }
                    override fun onError(e: Throwable?) {
                        postLoadError.value = true
                        loading.value = false
                        e!!.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposablePost.clear()
    }
}
