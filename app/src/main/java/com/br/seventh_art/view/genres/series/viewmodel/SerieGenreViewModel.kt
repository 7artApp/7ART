package com.br.seventh_art.view.genres.series.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.br.seventh_art.model.genre.seriesgenres.SerieGenre
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