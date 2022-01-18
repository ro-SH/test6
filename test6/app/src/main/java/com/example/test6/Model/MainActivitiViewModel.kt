package com.example.test6.Model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class MainActivitiViewModel: ViewModel() {
    private val mainrepo : Mainrepo
    val  getMovieList :LiveData<MutableList<Movies>>
    get() = mainrepo.getMovieModelLiveData

    init {
        mainrepo = Mainrepo()
    }

}