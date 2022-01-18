package com.example.test6.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.test6.Model.Movies
import com.example.test6.R
import com.squareup.picasso.Picasso


class Adapter( val context: Context, val imagelist:MutableList<Movies>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var  itemView = LayoutInflater.from(context).inflate(R.layout.layout_movies_item,p0,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        Picasso.get().load(imagelist[p1].imageurl).into(p0.images)
    }

    override fun getItemCount(): Int {
        return imagelist.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var images:ImageView
        //val binding =LayoutMoviesItemBinding.bind(itemView)
        init {
            images = itemView.findViewById(R.id.image)

        }

    }
}