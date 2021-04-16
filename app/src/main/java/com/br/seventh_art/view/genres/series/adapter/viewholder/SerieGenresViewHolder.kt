package com.br.seventh_art.view.genres.series.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

class SerieGenresViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val serieGenre by lazy {itemView.findViewById<TextView>(R.id.textview_serie_genres) }
}