package com.br.seventh_art.model.movie.moviePopular

data class MoviePopularResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)