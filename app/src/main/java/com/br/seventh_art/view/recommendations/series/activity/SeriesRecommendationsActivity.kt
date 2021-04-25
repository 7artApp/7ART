package com.br.seventh_art.view.recommendations.series.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.model.recommendation.seriesrecommendations.Result
import com.br.seventh_art.view.recommendations.series.adapter.SeriesRecAdapter


class SeriesRecommendationsActivity : AppCompatActivity(){

    private val SeriesRecommendationsViewModel by lazy {
        ViewModelProviders.of(this).get(com.br.seventh_art.view.recommendations.series.viewmodel.SeriesRecommendationsViewModel::class.java)
    }

    private val seriesRecList = mutableListOf<Result>()

    //DECLARAÇÃO DO RECYCLERVIEW ASSOCIADA À ACTIVITY
    private val recyclerView by lazy { findViewById<RecyclerView>(R.id.serie_recommendations_recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        setViewModel()
        setRecyclerView()
    }

    private fun initView() = setContentView(R.layout.activity_serie_recommendations)

    private fun getIntentData(): Int? {

        val intent = intent.extras

        return intent?.getInt("GENRE_ID")
    }

    private fun setViewModel(){

        val seriesGenre = getIntentData()
        Log.d("GENRE", seriesGenre.toString())

        seriesGenre?.let { SeriesRecommendationsViewModel.getSeriesRecommendations(it) }
        SeriesRecommendationsViewModel._listMutableSerieRec.observe(this, Observer {
            it?.let { itChar ->
                seriesRecList.addAll(itChar)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        })
    }

    private fun setRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = SeriesRecAdapter(seriesRecList, this)

    }
}
