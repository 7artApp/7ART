package com.br.seventh_art.data.model.genreMovie


import com.google.gson.annotations.SerializedName

data class MovieGenreResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)