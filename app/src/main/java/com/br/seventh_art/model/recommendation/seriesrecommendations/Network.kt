package com.br.seventh_art.model.recommendation.seriesrecommendations


import com.google.gson.annotations.SerializedName

data class Network(
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: Logo,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String
)