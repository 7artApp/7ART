package com.br.seventh_art.viewmodel.recommendations.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.seventh_art.model.recommendation.moviesrecommendations.Result
import com.br.seventh_art.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesRecommendationsViewModel: ViewModel() {

    val _listMutableMovieRec = MutableLiveData<List<Result>>()
    val listMutableMovieRec: LiveData<List<Result>> = _listMutableMovieRec

    val _movieGenre = MutableLiveData<Int>()
    val movieGenre: LiveData<Int> = _movieGenre

    private val repository = Repository()

    fun getAllMovieGenre() = CoroutineScope(Dispatchers.IO)
        .launch {
            repository.getMovieRecommendationsService(_movieGenre)
                .let { movieRecommendationsResponse ->
                    _listMutableMovieRec
                        .postValue(movieRecommendationsResponse.results)
                }
        }
}