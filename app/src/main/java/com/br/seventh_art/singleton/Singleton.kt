//Atributos para apresentar na tela de filmes:
//Gênero, nome do filme, duração, ano de lançamento, nota, sinopse/descrição



package com.br.seventh_art.singleton

import com.br.seventh_art.R


data class Movie(
    val title: String?,
    val length: Int?,
    val release: Int?,
    val score: Double?,
    val image: Int?,
    val disclaimer: String?
)

data class TvShow(
    val title: String?,
    val numberOfSeasons: Int?,
    val release: Int? = null,
    val score: Double?,
    val image: Int?,
    val disclaimer: String?
)

data class Genre(
    val id: Int? = null,
    val name: String
)

val avengersEndgame = Movie(
    "Avengers: Endgame",
    181,
    2019,
    8.3,
    R.drawable.avengers_endgame,
    " Após os eventos devastadores de Vingadores: Guerra Infinita, o universo está em ruínas devido aos esforços do Titã Louco, Thanos. Com a ajuda de aliados remanescentes, os Vingadores devem se reunir mais uma vez a fim de desfazer as ações de Thanos e restaurar a ordem no universo de uma vez por todas, não importando as consequências."
)

val interestelar = Movie(
    "Interestelas",
    169,
    2014,
    8.3,
    R.drawable.interestelar,
    " As reservas naturais da Terra estão chegando ao fim e um grupo de astronautas recebe a missão de verificar possíveis planetas para receberem a população mundial, possibilitando a continuação da espécie. Cooper é chamado para liderar o grupo e aceita a missão sabendo que pode nunca mais ver os filhos. Ao lado de Brand, Jenkins e Doyle, ele seguirá em busca de um novo lar."
)

val inception = Movie(
    "Inception",
    148,
    2010,
    8.3,
    R.drawable.inception,
    " Um ladrão que rouba segredos corporativos por meio do uso da tecnologia de compartilhamento de sonhos, recebe a tarefa inversa de plantar uma ideia na mente de um Diretor Executivo."

)

val whiplash = Movie(
    "Whiplash",
    165,
    2014,
    8.4,
    R.drawable.whiplash,
    " Andrew sonha em ser o melhor baterista de sua geração. Ele chama a atenção do impiedoso mestre do jazz Terence Fletcher, que ultrapassa os limites e transforma seu sonho em uma obsessão, colocando em risco a saúde física e mental do jovem músico."
)

val vForVendetta = Movie(
    "V for Vendetta",
    130,
    2006,
    7.9,
    R.drawable.v_for_vendetta,
    " Após uma guerra mundial, a Inglaterra é ocupada por um governo fascista e vive sob um regime totalitário. Na luta pela liberdade, um vigilante, conhecido apenas como V, utiliza-se de táticas terroristas para enfrentar os opressores da sociedade. V salva uma jovem chamada Evey da polícia secreta e encontra nela uma nova aliada em busca de liberdade e justiça para o seu país."
)

object MovieList {

    val list = movieList()

    fun movieList() : List<Movie>{

        var list = mutableListOf<Movie>()

        list.add(avengersEndgame)
        list.add(interestelar)
        list.add(inception)
        list.add(whiplash)
        list.add(vForVendetta)
        list.add(avengersEndgame)
        list.add(interestelar)
        list.add(inception)
        list.add(whiplash)
        list.add(vForVendetta)

        return list.toList()
    }
}

//<activity android:name=".view.MovieReadMoreActivity" >
//<activity android:name=".view.MovieActivity" >