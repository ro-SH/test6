package com.example.test6.Interface



import com.example.test6.Model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
    @GET("task-m-001")
    fun getmoviesList(): Call<MutableList<Movies>>
}