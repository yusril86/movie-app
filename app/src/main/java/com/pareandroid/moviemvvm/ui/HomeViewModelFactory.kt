package com.pareandroid.moviemvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pareandroid.moviemvvm.data.api.ApiEndPoint
import java.lang.IllegalArgumentException

class HomeViewModelFactory(private val apiService : ApiEndPoint):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(apiService) as  T
    }


}