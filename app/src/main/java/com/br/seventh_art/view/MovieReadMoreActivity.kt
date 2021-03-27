package com.br.seventh_art.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.br.seventh_art.R

class MovieReadMoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_read_more)

        val readMoreImage by lazy { findViewById<ImageView>(R.id.movie_poster) }
        val readMoreDisclaimer by lazy { findViewById<TextView>(R.id.sinopse_completa) }

        val movie = intent.extras
        val image = movie?.getInt("IMAGE")
        val disclaimer = movie?.getString("DISCLAIMER")

        image?.let { readMoreImage.setImageResource(it) }
        readMoreDisclaimer.text = disclaimer



    }
}