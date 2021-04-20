package com.br.seventh_art.network

import android.content.res.Configuration
import com.br.seventh_art.model.movie.genreMovie.MovieGenreResponse
import com.br.seventh_art.model.movie.moviePopular.MoviePopularResponse
import com.br.seventh_art.model.serie.genreSerie.SerieGenreResponse
import com.br.seventh_art.model.serie.seriePopular.SeriePopularResponse
import retrofit2.http.GET
import retrofit2.http.Query

// https://api.themoviedb.org/3/configuration?api_key=d00ab27062c01a80c4f6a7cefd66a6a5

interface EndPointApi {

    @GET ("configuration")
    suspend fun getConfig(
        @Query ("api_key") apiKey: String?
    ): Configuration

    @GET("genre/movie/list")
    suspend fun getAllGenreMovie(
        @Query("api_key") apiKey: String?
    ): MovieGenreResponse

    @GET("genre/tv/list")
    suspend fun getAllGenreSerie(
        @Query("api_key") apiKey: String?
    ):SerieGenreResponse

    @GET("movie/popular")
    suspend fun getAllPopularMovie(
        @Query("api_key") apiKey: String?
    ): MoviePopularResponse

    @GET("tv/popular")
    suspend fun getAllPopularSerie(
        @Query("api_key") apiKey: String?
    ): SeriePopularResponse
}