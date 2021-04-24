package com.br.seventh_art.view.genres.series.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R

import com.br.seventh_art.model.genre.seriesgenres.SerieGenre
import com.br.seventh_art.view.genres.movies.activity.MoviesGenresActivity
import com.br.seventh_art.view.genres.series.adapter.SerieGenresAdapter
import com.br.seventh_art.view.genres.series.viewmodel.SerieGenreViewModel

class SeriesGenresActivity : AppCompatActivity() {

    //DECLARAÇÃO DA LISTA QUE RECEBE OS DADOS DA VIEWMODEL DE SERIE GENRE E É PARÂMETRO DO ADAPTER
    var serieGenreList = mutableListOf<SerieGenre>()

    //DECLARAÇÃO DA VIEWMODEL DE SERIE GENRE
    private val viewModelSerieGenres by lazy {
        ViewModelProviders.of(this).get(SerieGenreViewModel::class.java)
    }

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.serie_genres_recyclerview) }

    //DECLARAÇÃO DO TEXTVIEW QUE ENDEREÇA À TELA DE FILMES
    private val moviesButton by lazy { findViewById<TextView>(R.id.text_series_genres_movies) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        initView()
        setRecyclerView()
        setViewModel()
        goToMovies()


    }

    private fun initView() = setContentView(R.layout.activity_genres_series)

    private fun setRecyclerView() {

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = SerieGenresAdapter(serieGenreList, this)
    }

    private fun setViewModel() {

        viewModelSerieGenres.getAllSerieGenre()
        viewModelSerieGenres.listMutableSerieGenre.observe(this, Observer {
            it?.let { itChar ->
                serieGenreList.addAll(itChar)
                recyclerView.adapter?.notifyDataSetChanged()

            }
        })
    }

    private fun goToMovies(){

        moviesButton.setOnClickListener{

            val intent = Intent(this, MoviesGenresActivity::class.java)
            it.context.startActivity(intent)
        }
    }


}