package com.br.seventh_art.view.recommendations.series.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.view.recommendations.series.adapter.viewholder.SeriesRecViewHolder
import com.squareup.picasso.Picasso

class SeriesRecAdapter(
    private val listSerie: List<com.br.seventh_art.model.recommendation.seriesrecommendations.Result>,
    val context: Context
) : RecyclerView.Adapter<SeriesRecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesRecViewHolder {

        val view = LayoutInflater
            .from(parent.context).inflate(
                R.layout.cardview_serie,
                parent,
                false
            )

        return SeriesRecViewHolder(
            view
        )
    }

    override fun getItemCount() = listSerie.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SeriesRecViewHolder, position: Int) {

        val imageUrl = "https://image.tmdb.org/t/p/original"

        val title = holder.serie_title
        title.text = listSerie[position].name

        val release = holder.serie_release
        release.text = listSerie[position].firstAirDate

        val score = holder.serie_score
        score.text = listSerie[position].voteAverage.toString() + " (IMDB)"

        val disclaimer = holder.serie_disclaimer
        disclaimer.text = listSerie[position].overview

        val image = holder.serie_image
        Picasso.get().load(imageUrl + listSerie[position].backdropPath).into(image)

//
//        disclaimer.setOnClickListener{
//
//            val intent = Intent(it.context, SerieReadMoreActivity::class.java)
//            intent.putExtra("IMAGE", list[position].image)
//            intent.putExtra("DISCLAIMER", text)
//            it.context.startActivity(intent)
//        }

    }
}