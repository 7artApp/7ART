package com.br.seventh_art.view.genres.series.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
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
import com.br.seventh_art.view.profile.ProfileActivity

class SeriesGenresActivity : AppCompatActivity() {

    //DECLARAÇÃO DA LISTA QUE RECEBE OS DADOS DA VIEWMODEL DE SERIE GENRE E É PARÂMETRO DO ADAPTER
    var serieGenreList = mutableListOf<SerieGenre>()

    val actionSeries = SerieGenre(10759, "Action & Adventure")
    val animationSeries = SerieGenre(16, "Animation")
    val comedySeries = SerieGenre(35, "Comedy")
    val documentarySeries = SerieGenre(99, "Documentary")
    val dramaSeries = SerieGenre(18, "Drama")
    val familySeries = SerieGenre(10751, "Family")
    val kidsSeries = SerieGenre(10762, "Kids")
    val newsSeries = SerieGenre(10763, "News")
    val realitySeries = SerieGenre(10764, "Reality")
    val fantasySeries = SerieGenre(10765, "Sci-Fi & Fantasy")
    val soapSeries = SerieGenre(10766, "Soap")
    val talkSeries = SerieGenre(10767, "Talk")
    val warSeries = SerieGenre(10768, "War & Politics")
    val westernSeries = SerieGenre(37, "Western")
    val misterySeries = SerieGenre(9648, "Mystery")

    val exceptionsSerieGenres = listOf<SerieGenre>(
        actionSeries,
        animationSeries,
        comedySeries,
        documentarySeries,
        dramaSeries,
        familySeries,
        kidsSeries,
        newsSeries,
        realitySeries,
        familySeries,
        soapSeries,
        fantasySeries,
        talkSeries,
        warSeries,
        westernSeries,
        misterySeries
    )


    //DECLARAÇÃO DA VIEWMODEL DE SERIE GENRE
    private val viewModelSerieGenres by lazy {
        ViewModelProviders.of(this).get(SerieGenreViewModel::class.java)
    }

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.serie_genres_recyclerview) }

    //DECLARAÇÃO DO TEXTVIEW QUE ENDEREÇA À TELA DE FILMES
    private val moviesButton by lazy { findViewById<TextView>(R.id.text_series_genres_movies) }

    private val buttonProfileSerie by lazy { findViewById<ImageView>(R.id.button_profile_movie) }

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
                exceptionsSerieGenres.forEach {
                    serieGenreList.remove(it)
                }

                recyclerView.adapter?.notifyDataSetChanged()
            }
        })

        serieGenreList.forEach { Log.d("LISTA DE GENEROS", "${it.name} | ${it.id}") }
    }

    fun goToMovies() {

        moviesButton.setOnClickListener {

            val intent = Intent(this, MoviesGenresActivity::class.java)
            it.context.startActivity(intent)
            finish()
        }
    }

    fun goToProfile(view: View) {
        buttonProfileSerie.setOnClickListener {

            val intent = Intent(this, ProfileActivity::class.java)
            it.context.startActivity(intent)
            finish()
        }
    }
}