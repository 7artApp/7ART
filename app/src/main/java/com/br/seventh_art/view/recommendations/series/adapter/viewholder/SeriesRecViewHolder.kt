package com.br.seventh_art.view.recommendations.series.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

class SeriesRecViewHolder(view: View) :  RecyclerView.ViewHolder(view) {

    val serie_image by lazy { itemView.findViewById<ImageView>(R.id.serie_image) }
    val serie_title by lazy { itemView.findViewById<TextView>(R.id.serie_title)}
    val serie_release  by lazy { itemView.findViewById<TextView>(R.id.serie_release) }
    val serie_score  by lazy { itemView.findViewById<TextView>(R.id.serie_score) }
    val serie_disclaimer by lazy { itemView.findViewById<TextView>(R.id.serie_disclaimer)}

}