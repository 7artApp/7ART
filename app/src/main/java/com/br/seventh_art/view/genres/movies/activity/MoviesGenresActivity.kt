package com.br.seventh_art.view.genres.movies.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.genreMovie.MovieGenre
import com.br.seventh_art.view.genres.movies.adapter.MovieGenresAdapter
import com.br.seventh_art.viewmodel.genres.movies.MovieGenreViewModel

class MoviesGenresActivity : AppCompatActivity() {

    //DECLARAÇÃO DA LISTA QUE RECEBE OS DADOS DA VIEWMODEL DE MOVIE GENRE E É PARÂMETRO DO ADAPTER
    var movieGenreList = mutableListOf<MovieGenre>()

    //DECLARAÇÃO DA VIEWMODEL DE MOVIE GENRE
    private val viewModelMovieGenres by lazy {
        ViewModelProviders.of(this).get(MovieGenreViewModel::class.java)
    }

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.movie_genres_recyclerview) }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initView()
        setRecyclerView()
        setViewModel()


    }

    private fun initView() = setContentView(R.layout.activity_movies_genres)

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


}