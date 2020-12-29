package com.pareandroid.moviemvvm.data.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
        @SerializedName("results")
        val results: ArrayList<Result>
)

data class Result(
        @SerializedName("title")
        val title: String,

        @SerializedName("overview")
        val overview: String
)
