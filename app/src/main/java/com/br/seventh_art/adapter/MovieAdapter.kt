package com.br.seventh_art.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.adapter.viewHolder.MovieViewHolder
import com.br.seventh_art.singleton.Movie
import com.br.seventh_art.view.MovieReadMoreActivity

class MovieAdapter(
    val list: List<Movie>
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater
            .from(parent.context).inflate(
                R.layout.cardview_movie,
                parent,
                false
            )

        return MovieViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {


        val image = holder.movie_image
        image.setImageResource(list[position].image!!)

        val title = holder.movie_title
        title.text = list[position].title

        val length = holder.movie_length
        length.text = list[position].length.toString() + " minutos"

        val release = holder.movie_release
        release.text = list[position].release.toString()

        val score = holder.movie_score
        score.text = list[position].score.toString() + " (IMDB)"

        val disclaimer = holder.movie_disclaimer
        val text = list[position].disclaimer
        disclaimer.text = shortText(text!!)

        disclaimer.setOnClickListener{

            val intent = Intent(it.context, MovieReadMoreActivity::class.java)
            intent.putExtra("IMAGE", list[position].image)
            intent.putExtra("DISCLAIMER", text)
            it.context.startActivity(intent)
        }

    }

    fun shortText(text: String): String? {

        val textList = text.split(" ")

        var smallerText = ""

        for (i in 1..30) {smallerText = smallerText + " " + textList[i]}

        smallerText += "...LEIA MAIS"

        return smallerText


    }
}