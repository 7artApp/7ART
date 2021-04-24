package com.br.seventh_art.view.genres.movies.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

import com.br.seventh_art.model.genre.moviesgenres.MovieGenre
import com.br.seventh_art.view.genres.movies.adapter.MovieGenresAdapter
import com.br.seventh_art.view.genres.series.activity.SeriesGenresActivity
import com.br.seventh_art.view.genres.movies.viewmodel.MovieGenreViewModel

class MoviesGenresActivity : AppCompatActivity() {

    //DECLARAÇÃO DA LISTA QUE RECEBE OS DADOS DA VIEWMODEL DE MOVIE GENRE E É PARÂMETRO DO ADAPTER
    var movieGenreList = mutableListOf<MovieGenre>()

    //DECLARAÇÃO DA VIEWMODEL DE MOVIE GENRE
    private val viewModelMovieGenres by lazy {
        ViewModelProviders.of(this).get(MovieGenreViewModel::class.java)
    }

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.movie_genres_recyclerview) }

    //DECLARAÇÃO DO TEXTVIEW QUE ENDEREÇA À TELA DE SÉRIES
    private val seriesButton by lazy { findViewById<TextView>(R.id.text_movie_genres_series) }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initView()
        setRecyclerView()
        setViewModel()
        goToSeries()


    }

    private fun initView() = setContentView(R.layout.activity_genres_movies)

    private fun setRecyclerView() {

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = MovieGenresAdapter(movieGenreList, this)
    }

    private fun setViewModel() {

        viewModelMovieGenres.getAllMovieGenre()
        viewModelMovieGenres.listMutableMovieGenre.observe(this, Observer {
            it?.let { itChar ->
                movieGenreList.addAll(itChar)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        })
    }

    private fun goToSeries(){

        seriesButton.setOnClickListener{

            val intent = Intent(this, SeriesGenresActivity::class.java)
            it.context.startActivity(intent)
        }
    }

}