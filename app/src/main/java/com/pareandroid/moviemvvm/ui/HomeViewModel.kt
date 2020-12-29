package com.pareandroid.moviemvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pareandroid.moviemvvm.data.api.ApiEndPoint
import com.pareandroid.moviemvvm.data.api.Config
import com.pareandroid.moviemvvm.data.model.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel(private val apiService : ApiEndPoint) : ViewModel() {
    private val dataMovie = MutableLiveData<HomeResponse>()

    fun fetchDataMovie (){
        /* val datasource = Config.apiServices
         datasource.discoverMovie().enqueue(object : Callback<HomeResponse> {
             override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                 response.body()?.results ?: emptyList()
             }

             override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
             }
         })*/

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




        /* val dataSource = Config.getRetrofit().create(ApiEndPoint::class.java)
         dataSource.discoverMovie().enqueue(object : Callback<BaseResponse>{
             override fun onResponse(call: Call<BaseResponse>, response: Response<BaseResponse>) {
                 if (response.isSuccessful){
                     dataMovie.postValue(response.body())
                 }else{
                     dataMovie.postValue(null)
                 }
             }

             override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                 dataMovie.postValue(null)
             }
         })*/
    }

    fun getDataMovie() : MutableLiveData<HomeResponse>{
        return dataMovie
    }


}