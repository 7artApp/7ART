package com.br.seventh_art.view.genres.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.genre.moviesgenres.MovieGenre
import com.br.seventh_art.view.genres.movies.adapter.viewholder.MovieGenresViewHolder

class MovieGenresAdapter(val movieGenres: List<MovieGenre>, val context: Context) :
    RecyclerView.Adapter<MovieGenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGenresViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.cardview_genres_movies, parent, false)
        return MovieGenresViewHolder(view)
    }

    override fun getItemCount(): Int = movieGenres.size

    override fun onBindViewHolder(holder: MovieGenresViewHolder, position: Int) {
        val genre = movieGenres.elementAt(position)

        holder.movieGenre.text = genre.name

        holder.itemView.setOnClickListener {

            genre.id
        }
    }
}