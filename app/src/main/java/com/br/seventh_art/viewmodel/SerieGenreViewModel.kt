package com.br.seventh_art.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.seventh_art.data.model.genreMovie.MovieGenre
import com.br.seventh_art.data.model.genreSerie.SerieGenre
import com.br.seventh_art.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SerieGenreViewModel: ViewModel() {

    val listMutableSerieGenre = MutableLiveData<List<SerieGenre>>()
    private val repository = Repository()

    fun getAllSerieGenre() = CoroutineScope(Dispatchers.IO)
        .launch {
            repository.getSerieGenreService()
                .let { serieGenreResponse ->
                    listMutableSerieGenre
                        .postValue(serieGenreResponse.genres)
                }
        }
}