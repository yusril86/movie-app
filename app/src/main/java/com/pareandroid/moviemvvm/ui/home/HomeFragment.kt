package com.pareandroid.moviemvvm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pareandroid.moviemvvm.R
import com.pareandroid.moviemvvm.adapter.HomeAdapter
import com.pareandroid.moviemvvm.ui.HomeViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class HomeFragment : Fragment() {


    lateinit var viewModel:HomeViewModel
    private var adapterHome: HomeAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
        viewModel.getDataMovie().observe(viewLifecycleOwner, {
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