package com.example.test6.common

import com.example.test6.Interface.RetrofitService
import com.example.test6.Model.Retrofit.RetrofitClient


object common {
    private val  BASE_URl = "https://dev-tasks.alef.im"
    val  retrofitService : RetrofitService

    get() = RetrofitClient.getClient(BASE_URl).create(RetrofitService :: class.java)
}