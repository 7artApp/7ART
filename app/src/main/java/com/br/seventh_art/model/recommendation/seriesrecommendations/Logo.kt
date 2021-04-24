package com.br.seventh_art.model.recommendation.seriesrecommendations


import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("aspect_ratio")
    val aspectRatio: Double,
    @SerializedName("path")
    val path: String
)