package com.pareandroid.moviemvvm.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pareandroid.moviemvvm.data.api.ApiEndPoint
import com.pareandroid.moviemvvm.data.api.Config
import com.pareandroid.moviemvvm.data.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel() : ViewModel() {
    private val dataMovie = MutableLiveData<HomeResponse>()

    fun fetchDataMovie (){

        try {
            val datasource = Config.apiServices
            datasource.discoverMovie().enqueue(object : Callback<HomeResponse> {
                override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                    dataMovie.postValue(response.body())
                }

                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                }
            })
        }catch (exception : Exception){
            dataMovie.postValue(null)
        }


    }

    fun getDataMovie() : MutableLiveData<HomeResponse>{
        return dataMovie
    }


}