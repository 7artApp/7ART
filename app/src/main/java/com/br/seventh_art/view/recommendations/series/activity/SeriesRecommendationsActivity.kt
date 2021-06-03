package com.br.seventh_art.view.recommendations.series.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.br.seventh_art.R
import com.br.seventh_art.model.recommendation.seriesrecommendations.Result
import com.br.seventh_art.view.recommendations.series.adapter.SeriesRecAdapter
import com.br.seventh_art.view.recommendations.series.viewmodel.SeriesRecommendationsViewModel
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview


class SeriesRecommendationsActivity : AppCompatActivity() {

    //DECLARAÇÃO DA VIEWMODEL DE MOVIE RECOMMENDATIONS
    private val SeriesRecommendationsViewModel by lazy {
        ViewModelProviders.of(this)
            .get(SeriesRecommendationsViewModel::class.java)
    }

    private val seriesRecList = mutableListOf<Result>()

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<CarouselRecyclerview>(R.id.series_recommendations_recycler_view) }

    private val serie_title by lazy { findViewById<TextView>(R.id.serie_title) }
    private val serie_release by lazy { findViewById<TextView>(R.id.serie_release) }
    private val serie_score by lazy { findViewById<TextView>(R.id.serie_score) }
    private val serie_disclaimer by lazy { findViewById<TextView>(R.id.serie_disclaimer) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setViewModel()
        initView()

        setRecyclerView()
        setViewData()
    }

    private fun initView() {
        setContentView(R.layout.activity_serie_recommendations)

    }
    private fun getIntentData(): Int? {

        val intent = intent.extras
        val serieGenre = intent?.getInt("GENRE_ID")

        return serieGenre
    }

    private fun setViewModel(){

        val serieGenre = getIntentData()
        Log.d("GENRE", serieGenre.toString())

        serieGenre?.let { SeriesRecommendationsViewModel.getSeriesRecommendations(it) }
        SeriesRecommendationsViewModel._listMutableSerieRec.observe(this, Observer {
            it?.let { itChar ->
                seriesRecList.addAll(itChar)
                recyclerView.adapter?.notifyDataSetChanged()
            }
            serie_title.text = seriesRecList[0].name
            serie_release.text = seriesRecList[0].firstAirDate
            serie_score.text = seriesRecList[0].voteAverage.toString() + " (IMDB)"
            serie_disclaimer.text = seriesRecList[0].overview
        })
    }


    private fun setRecyclerView(){
        recyclerView.adapter = SeriesRecAdapter(seriesRecList, this)
        recyclerView.set3DItem(false)
        recyclerView.setAlpha(true)
        recyclerView.setInfinite(false)

    }

    private fun setViewData(){

        recyclerView.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {
                serie_title.text = seriesRecList[position].name
                serie_release.text = seriesRecList[position].firstAirDate
                serie_score.text = seriesRecList[position].voteAverage.toString() + " (IMDB)"
                serie_disclaimer.text = seriesRecList[position].overview
            }
        })
    }

}