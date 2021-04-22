package com.br.seventh_art.model.recommendation.moviesrecommendations


import com.google.gson.annotations.SerializedName

data class MoviesRecommendationsResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)