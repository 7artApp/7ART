package com.br.seventh_art.network

import com.br.seventh_art.model.genreMovie.MovieGenreResponse
import com.br.seventh_art.model.genreSerie.SerieGenreResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface EndPointApi {

    @GET("genre/movie/list")
    suspend fun getAllGenreMovie(
        @Query("api_key") apiKey: String
    ): MovieGenreResponse

    @GET("genre/tv/list")
    suspend fun getAllGenreSerie(
        @Query("api_key") apiKey: String
    ):SerieGenreResponse
}