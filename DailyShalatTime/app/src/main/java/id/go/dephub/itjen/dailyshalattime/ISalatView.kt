package id.go.dephub.itjen.dailyshalattime

import id.go.dephub.itjen.dailyshalattime.model.Item

interface ISalatView {
    fun onDataCompleteFromApi(salat: Item)
    fun onDataErrorFromApi(throwable: Throwable)
}