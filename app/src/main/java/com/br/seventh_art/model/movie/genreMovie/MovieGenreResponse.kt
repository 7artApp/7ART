package com.br.seventh_art.model.movie.genreMovie


import com.google.gson.annotations.SerializedName

data class MovieGenreResponse(
    @SerializedName("genres")
    val genres: List<MovieGenre>
)