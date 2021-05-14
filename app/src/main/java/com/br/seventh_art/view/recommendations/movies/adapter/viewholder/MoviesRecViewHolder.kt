package com.br.seventh_art.view.recommendations.movies.adapter.viewholder

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

class MoviesRecViewHolder(
    view: View
):  RecyclerView.ViewHolder(view) {

    val movie_image by lazy { itemView.findViewById<ImageView>(R.id.movie_image) }

}