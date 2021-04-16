package com.br.seventh_art.network

import com.br.seventh_art.model.genreMovie.MovieGenreResponse
import com.br.seventh_art.model.genreSerie.SerieGenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.themoviedb.org/3/genre/tv/list?api_key=d00ab27062c01a80c4f6a7cefd66a6a5&language=en-US
//https://api.themoviedb.org/3/genre/movie/list?api_key=d00ab27062c01a80c4f6a7cefd66a6a5&language=en-US
interface EndPointApi {

    @GET("/genre/movie/list")
    suspend fun getAllGenreMovie(
        @Query("api_key") apiKey: String
    ): MovieGenreResponse

    @GET("/genre/tv/list")
    suspend fun getAllGenreSerie(
        @Query("api_key") apiKey: String
    ):SerieGenreResponse
}