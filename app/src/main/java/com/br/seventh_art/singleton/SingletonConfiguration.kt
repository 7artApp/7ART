package com.br.seventh_art.singleton

import com.br.seventh_art.model.ConfigurationApi

object SingletonConfiguration {

    var config: ConfigurationApi? = null

    fun setConfiguration(configuration: ConfigurationApi) {
        config = configuration
    }
}