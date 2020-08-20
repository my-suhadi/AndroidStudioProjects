package id.go.dephub.itjen.portal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.go.dephub.itjen.portal.model.PostModel

class DetailPostViewModel : ViewModel() {
    internal val postLiveData = MutableLiveData<PostModel>()

    fun fetch() {
    }
}