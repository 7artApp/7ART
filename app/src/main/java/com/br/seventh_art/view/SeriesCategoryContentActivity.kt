package com.br.seventh_art.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.adapter.CategoryContentListAdapter
import com.br.seventh_art.model.CategoryContent


class SeriesCategoryContentActivity : AppCompatActivity() {
    var gridLayoutManager:GridLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.series_category_activity_content)
        initViews()

    }

    private fun initViews() {
        val recyclerView by lazy { findViewById<RecyclerView>(R.id.series_category_content_activity_recycler_view) }
        val tvFilmes by lazy { findViewById<TextView>(R.id.series_category_content_activity_toolbar_filmes) }
//        val toolbar by lazy { findViewById<Toolbar>(R.id.series_category_content_activity_toolbar) }
//        val tvSeries by lazy { findViewById<TextView>(R.id.series_category_content_activity_toolbar_Series) }
//        val divider by lazy { findViewById<View>(R.id.divider3) }

        val list = categoryList().toList()

        gridLayoutManager = GridLayoutManager(applicationContext, 2,LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = gridLayoutManager

        recyclerView.adapter = CategoryContentListAdapter(list)

        tvFilmes.setOnClickListener {
          Intent(this, CategoryContentActivity::class.java).also { startActivity(it) }
        }
    }

    private fun categoryList(): MutableList<CategoryContent> {
        val list = mutableListOf<CategoryContent>()
        list.clear()
        list.add(CategoryContent(R.drawable.poster_soul,"Séries de Comédia"))
        list.add(CategoryContent( R.drawable.poster_psycho,"Séries de Terror"))
        list.add(CategoryContent( R.drawable.poster_inception,"Séries de Ação"))
        list.add(CategoryContent( R.drawable.poster_doentes_de_amor,"Séries Romànticas"))
        list.add(CategoryContent(R.drawable.poster_lista_de_schindler,"Séries de Drama"))
        list.add(CategoryContent(R.drawable.poster_jumanji,"Séries Documentais"))
        list.add(CategoryContent( R.drawable.poster_jumanji,"Séries de Suspense"))
        list.add(CategoryContent(R.drawable.poster_soul,"Séries animadas"))
        list.add(CategoryContent( R.drawable.poster_nova_ordem_espacial,"Séries de Ficção científica"))

        return list
    }



}