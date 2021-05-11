package com.br.seventh_art.view.recommendations.movies.activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.br.seventh_art.R
import com.br.seventh_art.model.recommendation.moviesrecommendations.Result
import com.br.seventh_art.view.recommendations.movies.adapter.MoviesRecAdapter
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview


class   MoviesRecommendationsActivity : AppCompatActivity() {

    //DECLARAÇÃO DA VIEWMODEL DE MOVIE RECOMMENDATIONS
    private val MoviesRecommendationsViewModel by lazy {
        ViewModelProviders.of(this)
            .get(com.br.seventh_art.view.recommendations.movies.viewmodel.MoviesRecommendationsViewModel::class.java)
    }


    private val moviesRecList = mutableListOf<Result>()


    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<CarouselRecyclerview>(R.id.movies_recommendations_recycler_view) }

    private val movie_title by lazy { findViewById<TextView>(R.id.movie_title) }
    private val movie_release by lazy { findViewById<TextView>(R.id.movie_release) }
    private val movie_score by lazy { findViewById<TextView>(R.id.movie_score) }
    private val movie_disclaimer by lazy { findViewById<TextView>(R.id.movie_disclaimer) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setViewModel()
        initView()

        setRecyclerView()
        setViewData()
    }

    private fun initView() {
    setContentView(R.layout.activity_movies_recommendations)

    }
    private fun getIntentData(): Int? {

        val intent = intent.extras
        val movieGenre = intent?.getInt("GENRE_ID")

        return movieGenre
    }

    private fun setViewModel(){

        val movieGenre = getIntentData()
        Log.d("GENRE", movieGenre.toString())

        movieGenre?.let { MoviesRecommendationsViewModel.getMoviesRecommendations(it) }
        MoviesRecommendationsViewModel._listMutableMovieRec.observe(this, Observer {
            it?.let { itChar ->
                moviesRecList.addAll(itChar)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        })
    }


    private fun setRecyclerView(){
        recyclerView.adapter = MoviesRecAdapter(moviesRecList, this)
        recyclerView.set3DItem(false)
        recyclerView.setAlpha(true)
        recyclerView.setInfinite(false)

    }

    private fun setViewData(){

       recyclerView.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {
                movie_title.text = moviesRecList[position].title
                movie_release.text = moviesRecList[position].releaseDate
                movie_score.text = moviesRecList[position].voteAverage.toString() + " (IMDB)"
                movie_disclaimer.text = moviesRecList[position].overview
            }
        })
    }

}
