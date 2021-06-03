package com.br.seventh_art.view.recommendations.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.recommendation.moviesrecommendations.Result
import com.br.seventh_art.view.recommendations.movies.adapter.viewholder.MoviesRecViewHolder
import com.squareup.picasso.Picasso

class MoviesRecAdapter(
    val listMovie: List<Result>,
    val context: Context
) : RecyclerView.Adapter<MoviesRecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesRecViewHolder {

        val view = LayoutInflater
            .from(parent.context).inflate(
                R.layout.cardview_movie,
                parent,
                false
            )

        return MoviesRecViewHolder(
            view
        )
    }

    override fun getItemCount() = listMovie.size

    override fun onBindViewHolder(holder: MoviesRecViewHolder, position: Int) {

        val imageUrl = "https://image.tmdb.org/t/p/original"

        val image = holder.movie_image
        Picasso.get().load(imageUrl + listMovie[position].backdropPath).into(image)
    }

}