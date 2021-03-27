package com.br.seventh_art.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.adapter.MovieAdapter
import com.br.seventh_art.model.Content
import com.br.seventh_art.singleton.MovieList

class MovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_content)

        initViews()
    }

    private fun initViews() {
        setContentView(R.layout.activity_movie)

        val recyclerView by lazy { findViewById<RecyclerView>(R.id.movie_recycler_view) }

        val list = MovieList.list

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = MovieAdapter(list)

    }
}