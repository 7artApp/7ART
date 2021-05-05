package com.br.seventh_art.model.recommendation.seriesrecommendations


import com.google.gson.annotations.SerializedName

data class SeriesRecommendationsResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)