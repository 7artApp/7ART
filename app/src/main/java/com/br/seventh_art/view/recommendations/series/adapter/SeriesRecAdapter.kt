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

        val image = holder.serie_image
        Picasso.get().load(imageUrl + listSerie[position].backdropPath).into(image)

    }
}