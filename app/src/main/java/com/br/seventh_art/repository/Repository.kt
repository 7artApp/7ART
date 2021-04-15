package com.br.seventh_art.repository

import RetrofitInit
import com.br.seventh_art.network.EndPointApi

class Repository {

    private var url = "https://api.themoviedb.org/3/"
    private var service = EndPointApi::class
    private var chave = "d00ab27062c01a80c4f6a7cefd66a6a5"

    private val serviceApp = RetrofitInit(url).create(service)

//    suspend fun getCharacterService(): CharacterResponse = serviceApp.getResponseCharacter()
}