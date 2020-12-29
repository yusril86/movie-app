package com.pareandroid.moviemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pareandroid.moviemvvm.R
import com.pareandroid.moviemvvm.data.model.Result
import kotlinx.android.synthetic.main.item_movie.view.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var mListMovie : MutableList<Result> = ArrayList()

    /*fun setListData(data : ArrayList<MovieResponse>){
        *//*if(mListMovie == null){
            mListMovie.addAll(data)
            mListMovieFilter.addAll(data)
            notifyItemChanged(0,mListMovieFilter.size)
        }else{
            val result =DiffUtil.calculateDiff(object : DiffUtil.Callback(){
                override fun getOldListSize(): Int {
                   return mListMovie.size
                }

                override fun getNewListSize(): Int {
                   return mListMovie.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return mListMovie.get(oldItemPosition).title===data[newItemPosition].title
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    val newDataModel = mListMovie.get(oldItemPosition)
                    val oldDataModel = data[newItemPosition]
                    return newDataModel.title === oldDataModel.title
                }

            })
            mListMovie.addAll(data)
            mListMovieFilter.addAll(data)
            result.dispatchUpdatesTo(this)
        }*//*
        this.mListMovie = data
    }*/

    fun updateAdapter(list: ArrayList<Result>) {
       this.mListMovie = list
//        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        /*val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return ViewHolder(view)*/
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)

        )
    }



    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        holder.itemView.apply {
            mListMovie[position].apply {
                tv_judul.text = title
                tv_description.text = overview
            }
        }

      /*  holder.bind(mListMovie[holder.adapterPosition])*/
    }

    override fun getItemCount(): Int {
        return mListMovie.size
    }

    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {
       /* fun bind(result: Result) {
            with(itemView) {
                tv_judul.text = result.title
                tv_description.text = result.overview
            }
        }*/
    }
}