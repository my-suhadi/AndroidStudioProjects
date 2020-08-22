package id.go.dephub.itjen.portal.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import id.go.dephub.itjen.portal.model.PostDatabase
import id.go.dephub.itjen.portal.model.PostModel
import id.go.dephub.itjen.portal.model.RetrofitApiService
import id.go.dephub.itjen.portal.util.SharedPreferencesHelper
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class PostListViewModel(app: Application) : BaseViewModel(app) {

    private val postApiService = RetrofitApiService()
    private val disposablePost = CompositeDisposable()
    private val prefHelper = SharedPreferencesHelper(getApplication())
    private val refreshTime = 10 * 1000 * 1000 * 1000L

    internal val allPosts = MutableLiveData<List<PostModel>>()
    internal val postLoadError = MutableLiveData<Boolean>()
    internal val loading = MutableLiveData<Boolean>()

    internal fun refresh() {
        val updateTime = prefHelper.getLastUpdateTime()
        if (updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            fetchFromDatabase()
        } else {
            fetchFromRemote()
        }
    }

    internal fun refreshBypassDatabase() {
        fetchFromRemote()
    }

    private fun fetchFromDatabase() {
        launch {
            val allPosts = PostDatabase(getApplication()).postDao().getSemuaPost()
            retrieveAllPosts(allPosts)
            Toast.makeText(getApplication(), "Posts retrieved from database", Toast.LENGTH_LONG).show()
        }
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposablePost.add(
            postApiService.getAllPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<PostModel>>() {
                    override fun onSuccess(value: List<PostModel>) {
                        storePostLocally(value)
                    }

                    override fun onError(e: Throwable?) {
                        postLoadError.value = true
                        loading.value = false
                        e!!.printStackTrace()
                    }
                })
        )
    }

    private fun retrieveAllPosts(_postList: List<PostModel>) {
        allPosts.value = _postList
        postLoadError.value = false
        loading.value = false
    }

    private fun storePostLocally(_postList: List<PostModel>) {
        launch {
            val dao = PostDatabase(getApplication()).postDao()
            dao.hapusSemuaPost()
            val result = dao.insertSemua(*_postList.toTypedArray())
            var i = 0
            while (i < _postList.size) {
                _postList[i].postId = result[i].toInt()
                i++
            }
            retrieveAllPosts(_postList)
        }
        prefHelper.savedUpdateTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()
        disposablePost.clear()
    }
}
