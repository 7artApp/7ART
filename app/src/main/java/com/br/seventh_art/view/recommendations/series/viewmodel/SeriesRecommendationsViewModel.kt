package com.br.seventh_art.view.recommendations.series.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.seventh_art.model.recommendation.seriesrecommendations.Result
import com.br.seventh_art.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeriesRecommendationsViewModel: ViewModel() {

    var _listMutableSerieRec = MutableLiveData<List<Result>>()
    val listMutableSerieRec: LiveData<List<Result>> = _listMutableSerieRec

    private val repository = Repository()

    fun getSeriesRecommendations(genre: Int) = CoroutineScope(Dispatchers.IO)
        .launch {
            repository.getSerieRecommendationsService(genre)
                .let { SeriesRecommendationsResponse ->
                    _listMutableSerieRec
                        .postValue(SeriesRecommendationsResponse.results)
                }
        }
}