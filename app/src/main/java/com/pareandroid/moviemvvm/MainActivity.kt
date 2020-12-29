package com.pareandroid.moviemvvm

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pareandroid.moviemvvm.adapter.HomeAdapter
import com.pareandroid.moviemvvm.data.api.Config
import com.pareandroid.moviemvvm.data.model.HomeResponse
import com.pareandroid.moviemvvm.ui.HomeViewModel
import com.pareandroid.moviemvvm.ui.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
         lateinit var viewModel:HomeViewModel
    private var adapterHome: HomeAdapter = HomeAdapter()
    private val mlistData = ArrayList<HomeResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_home.apply {
            adapter = adapterHome
            setHasFixedSize(true)
        }

        setUpViewModel()
        showMovie()

    }

    private fun showMovie(){
//        val  viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.fetchDataMovie()
        viewModel.getDataMovie().observe(this, {
            it.let { data ->
                data.apply {
                    adapterHome.updateAdapter(it.results)
                    adapterHome.notifyDataSetChanged()
                }
            }
//            viewModel.fetchDataMovie()

        })
    }

        private fun setUpViewModel(){
        this.let {
            viewModel = ViewModelProvider(it, HomeViewModelFactory(Config.apiServices)
            ).get(HomeViewModel::class.java)
        }
    }


}