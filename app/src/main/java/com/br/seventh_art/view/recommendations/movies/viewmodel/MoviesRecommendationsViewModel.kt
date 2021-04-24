package com.br.seventh_art.view.recommendations.movies.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.seventh_art.model.recommendation.moviesrecommendations.Result
import com.br.seventh_art.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesRecommendationsViewModel: ViewModel() {

    var _listMutableMovieRec = MutableLiveData<List<Result>>()
    val listMutableMovieRec: LiveData<List<Result>> = _listMutableMovieRec

    private val repository = Repository()

    fun getMoviesRecommendations(genre: Int) = CoroutineScope(Dispatchers.IO)
        .launch {
            repository.getMovieRecommendationsService(genre)
                .let { movieRecommendationsResponse ->
                    _listMutableMovieRec
                        .postValue(movieRecommendationsResponse.results)
                }
        }
}