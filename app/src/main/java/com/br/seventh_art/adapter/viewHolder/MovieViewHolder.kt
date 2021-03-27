package com.br.seventh_art.adapter.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

class MovieViewHolder(
    view: View
):  RecyclerView.ViewHolder(view) {

    val movie_image by lazy { itemView.findViewById<ImageView>(R.id.movie_image) }
    val movie_title by lazy { itemView.findViewById<TextView>(R.id.movie_title)}
    val movie_length  by lazy { itemView.findViewById<TextView>(R.id.movie_length) }
    val movie_release  by lazy { itemView.findViewById<TextView>(R.id.movie_release) }
    val movie_score  by lazy { itemView.findViewById<TextView>(R.id.movie_score) }
    val movie_disclaimer by lazy { itemView.findViewById<TextView>(R.id.movie_disclaimer)}

}