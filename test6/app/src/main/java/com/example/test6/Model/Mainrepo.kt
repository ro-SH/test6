package com.example.test6.Model

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.test6.Interface.RetrofitService
import com.example.test6.common.common
import retrofit2.Call
import retrofit2.Response

class Mainrepo {
    private val retrofitService : RetrofitService

    companion object{
        private const val TAG = "MainRepo"
    }
    init {
        retrofitService = common.retrofitService
    }
    val getMovieModelLiveData: MutableLiveData<MutableList<Movies>>
    get() {
        val  data: MutableLiveData<MutableList<Movies>> = MutableLiveData<MutableList<Movies>>()
        retrofitService.getmoviesList().enqueue(object :retrofit2.Callback<MutableList<Movies>>{
            override fun onResponse(
                call: Call<MutableList<Movies>>,
                response: Response<MutableList<Movies>>
            ) {
                Log.e(TAG,"Onresponse: " + response.code() )
                if (response.isSuccessful){
                    data.value = response.body()
                }
                else{
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<Movies>>, t: Throwable) {
                Log.e(TAG,"Onresponse: " + t.message)
                data.value = null
            }

        })
        return data

    }
}