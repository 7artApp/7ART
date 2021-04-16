package com.br.seventh_art.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.seventh_art.data.model.genreMovie.MovieGenre
import com.br.seventh_art.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieGenreViewModel: ViewModel() {

    val listMutableMovieGenre = MutableLiveData<List<MovieGenre>>()
    private val repository = Repository()

    fun getAllMovieGenre() = CoroutineScope(Dispatchers.IO)
        .launch {
            repository.getMovieGenreService()
                .let { movieGenreResponse ->
                    listMutableMovieGenre
                        .postValue(movieGenreResponse.genres)
                }
        }
}