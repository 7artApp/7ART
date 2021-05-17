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

//        val imageUrl = "https://image.tmdb.org/t/p/w185"
//        val imageUrl = "https://image.tmdb.org/t/p/w500"
        val imageUrl = "https://image.tmdb.org/t/p/original"

//        val title = holder.movie_title
//        title.text = listMovie[position].title
//
//        val release = holder.movie_release
//        release.text = listMovie[position].releaseDate
//
//        val score = holder.movie_score
//        score.text = listMovie[position].voteAverage.toString() + " (IMDB)"
//
//        val disclaimer = holder.movie_disclaimer
//        disclaimer.text = listMovie[position].overview

        val image = holder.movie_image
        Picasso.get().load(imageUrl + listMovie[position].backdropPath).into(image)

//
//        disclaimer.setOnClickListener{
//
//            val intent = Intent(it.context, MovieReadMoreActivity::class.java)
//            intent.putExtra("IMAGE", list[position].image)
//            intent.putExtra("DISCLAIMER", text)
//            it.context.startActivity(intent)
//        }

    }

    }