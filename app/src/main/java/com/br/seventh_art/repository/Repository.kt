package com.br.seventh_art.repository

import RetrofitInit

import com.br.seventh_art.model.genre.moviesgenres.MovieGenreResponse
import com.br.seventh_art.model.genre.seriesgenres.SerieGenreResponse
import com.br.seventh_art.model.recommendation.moviesrecommendations.MoviesRecommendationsResponse
import com.br.seventh_art.model.recommendation.seriesrecommendations.SeriesRecommendationsResponse
import com.br.seventh_art.network.EndPointApi

const val API_KEY = "d00ab27062c01a80c4f6a7cefd66a6a5"


class Repository{

    private var url = "https://api.themoviedb.org/3/"
    private var service = EndPointApi::class

    private val serviceApp = RetrofitInit(url).create(service)

    suspend fun getConfigurationService(): Configuration = serviceApp.getConfig(API_KEY)
    suspend fun getMovieGenreService():MovieGenreResponse = serviceApp.getAllGenreMovie(API_KEY)
    suspend fun getSerieGenreService(): SerieGenreResponse = serviceApp.getAllGenreSerie(API_KEY)

    suspend fun getMovieRecommendationsService(movie_genre: Int): MoviesRecommendationsResponse = serviceApp.getMoviesRecommendations(movie_genre, API_KEY)
    suspend fun getSerieRecommendationsService(serie_genre: Int): SeriesRecommendationsResponse = serviceApp.getSeriesRecommendations(serie_genre, API_KEY)

}