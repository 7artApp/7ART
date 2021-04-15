package com.br.seventh_art.repository

import RetrofitInit
import com.br.seventh_art.data.model.genre.MovieGenreResponse
import com.br.seventh_art.network.EndPointApi

const val API_KEY = "d00ab27062c01a80c4f6a7cefd66a6a5"

class Repository{
    private var url = "https://api.themoviedb.org/3"
    private var service = EndPointApi::class

    private val serviceApp = RetrofitInit(url).create(service)

    suspend fun getMovieGenreServie():MovieGenreResponse = serviceApp.getAllGenre(API_KEY)

}