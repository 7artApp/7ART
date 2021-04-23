package com.br.seventh_art.network

import com.br.seventh_art.model.genre.moviesgenres.MovieGenreResponse
import com.br.seventh_art.model.genre.seriesgenres.SerieGenreResponse
import com.br.seventh_art.model.recommendation.moviesrecommendations.MoviesRecommendationsResponse
import com.br.seventh_art.model.recommendation.seriesrecommendations.SeriesRecommendationsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface EndPointApi {

    /*
    *       GÊNEROS DE FILMES
    */

    @GET("genre/movie/list")
    suspend fun getAllGenreMovie(
        @Query("api_key") apiKey: String
    ): MovieGenreResponse

    /*
    *       GÊNEROS DE SÉRIES
    */

    @GET("genre/tv/list")
    suspend fun getAllGenreSerie(
        @Query("api_key") apiKey: String
    ):SerieGenreResponse

    /*
    *       RECOMENDAÇÕES DE FILMES = https://api.themoviedb.org/3/movie/28/recommendations?api_key=d00ab27062c01a80c4f6a7cefd66a6a5
    */

    @GET("movie/{movie_id}/recommendations")
    suspend fun getMoviesRecommendations(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ):MoviesRecommendationsResponse

    /*
    *       RECOMENDAÇÕES DE SÉRIES
    */

    @GET("tv/{serie_id}/recommendations")
    suspend fun getSeriesRecommendations(
        @Path("serie_id") serieId: Int,
        @Query("api_key") apiKey: String
    ):SeriesRecommendationsResponse
}