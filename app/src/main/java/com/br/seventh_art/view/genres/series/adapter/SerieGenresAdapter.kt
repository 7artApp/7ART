package com.br.seventh_art.view.genres.series.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.serie.genreSerie.SerieGenre
import com.br.seventh_art.view.genres.series.adapter.viewholder.SerieGenresViewHolder

class SerieGenresAdapter(val serieGenres: List<SerieGenre>, val context: Context) :
    RecyclerView.Adapter<SerieGenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SerieGenresViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.cardview_genres_series, parent, false)
        return SerieGenresViewHolder(view)
    }

    override fun getItemCount(): Int = serieGenres.size


    override fun onBindViewHolder(holder: SerieGenresViewHolder, position: Int) {
        val genre = serieGenres.elementAt(position)

        holder.serieGenre.text = genre.name
    }
}