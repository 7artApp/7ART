package com.br.seventh_art.model.serie.seriePopular

data class SeriePopularResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)