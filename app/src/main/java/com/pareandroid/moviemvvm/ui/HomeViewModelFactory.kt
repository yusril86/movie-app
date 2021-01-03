package com.pareandroid.moviemvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pareandroid.moviemvvm.ui.home.HomeViewModel

class HomeViewModelFactory:ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel() as  T
    }


}