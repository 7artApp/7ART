package com.br.seventh_art.view.genres.movies.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

class MovieGenresViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val movieGenre by lazy {itemView.findViewById<TextView>(R.id.textview_movie_genres) }
    val imageGenre by lazy {itemView.findViewById(R.id.image_genre)}
}