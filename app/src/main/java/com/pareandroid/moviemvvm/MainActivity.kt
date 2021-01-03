package com.pareandroid.moviemvvm

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pareandroid.moviemvvm.adapter.HomeAdapter
import com.pareandroid.moviemvvm.ui.home.HomeViewModel
import com.pareandroid.moviemvvm.ui.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: HomeViewModel
    private var adapterHome: HomeAdapter = HomeAdapter()

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
        // fetchDataMovie to get Data from server with retrofit
        //getDataMovie is Livedata and observe to show the Livedata in UI
        viewModel.fetchDataMovie()
        viewModel.getDataMovie().observe(this, {
            //it adalah sebuah receiver untuk menampung value dari response
            // also adalah sebuah scope funtion untuk melempar value(response) aslinya
            // let adaalah sebuah scope function untuk melempar value untuk proses selanjutyna
            it.also { data ->
                data.apply {
                    adapterHome.updateAdapter(it.results)
                    adapterHome.notifyDataSetChanged()
                    pb_home.visibility= View.GONE
                }
            }

        })
    }

    private fun setUpViewModel(){
        this.let {
            viewModel = ViewModelProvider(it, HomeViewModelFactory()
            ).get(HomeViewModel::class.java)
        }
    }


}