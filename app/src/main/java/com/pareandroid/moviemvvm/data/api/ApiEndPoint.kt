package com.pareandroid.moviemvvm.data.api

import com.pareandroid.moviemvvm.BuildConfig
import com.pareandroid.moviemvvm.data.model.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {
    /*@GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey:String = BuildConfig.API_KEY
    ): Call<BaseResponse>*/

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey : String = BuildConfig.API_KEY
    ):Call<HomeResponse>
}