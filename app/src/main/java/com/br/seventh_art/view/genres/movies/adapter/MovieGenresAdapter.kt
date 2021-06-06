package com.br.seventh_art.view.genres.movies.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.genre.moviesgenres.MovieGenre
import com.br.seventh_art.view.genres.movies.adapter.viewholder.MovieGenresViewHolder
import com.br.seventh_art.view.recommendations.movies.activity.MoviesRecommendationsActivity
import com.squareup.picasso.Picasso

class MovieGenresAdapter(val movieGenres: List<MovieGenre>, val context: Context) :
    RecyclerView.Adapter<MovieGenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGenresViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.cardview_genres_movies, parent, false)
        return MovieGenresViewHolder(view)
    }

    override fun getItemCount(): Int = movieGenres.size

    override fun onBindViewHolder(holder: MovieGenresViewHolder, position: Int) {

        val imageUrl = "https://image.tmdb.org/t/p/original"

        val image = holder.movie_image
        Picasso.get().load(imageUrl + listMovie[position].backdropPath).into(image)

        val genre = movieGenres.elementAt(position)

        holder.movieGenre.text = genre.name

        holder.itemView.setOnClickListener {

            val intent = Intent(it.context, MoviesRecommendationsActivity::class.java)
            intent.putExtra("GENRE_ID", genre.id)
            it.context.startActivity(intent)
        }
    }
}