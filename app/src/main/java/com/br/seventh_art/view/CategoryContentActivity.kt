package com.br.seventh_art.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.br.seventh_art.R
import com.br.seventh_art.adapter.CategoryContentListAdapter
import com.br.seventh_art.model.CategoryContent
import com.br.seventh_art.view.SeriesCategoryContentActivity


class CategoryContentActivity : AppCompatActivity() {
    var gridLayoutManager:GridLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_activity_content)
        initViews()

    }

    private fun initViews() {
        val recyclerView by lazy { findViewById<RecyclerView>(R.id.category_content_activity_recycler_view) }
//        val toolbar by lazy { findViewById<Toolbar>(R.id.category_content_activity_toolbar) }
//        val tvFilmes by lazy { findViewById<TextView>(R.id.category_content_activity_toolbar_filmes) }
        val tvSeries by lazy { findViewById<TextView>(R.id.category_content_activity_toolbar_Series) }

        val list = categoryList().toList()

        gridLayoutManager = GridLayoutManager(applicationContext, 2,LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = gridLayoutManager

        recyclerView.adapter = CategoryContentListAdapter(list)

        tvSeries.setOnClickListener {
            Intent(this, SeriesCategoryContentActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun categoryList(): MutableList<CategoryContent> {
        val list = mutableListOf<CategoryContent>()

        list.clear()
        list.add(CategoryContent(R.drawable.poster_soul,"Comédia"))
        list.add(CategoryContent( R.drawable.poster_psycho,"Terror"))
        list.add(CategoryContent( R.drawable.poster_inception,"Ação"))
        list.add(CategoryContent( R.drawable.poster_doentes_de_amor,"Romance"))
        list.add(CategoryContent(R.drawable.poster_lista_de_schindler,"Drama"))
        list.add(CategoryContent(R.drawable.poster_jumanji,"Documentários"))
        list.add(CategoryContent( R.drawable.poster_jumanji,"Suspense"))
        list.add(CategoryContent(R.drawable.poster_soul,"Animações"))
        list.add(CategoryContent( R.drawable.poster_nova_ordem_espacial,"Ficção científica"))

        return list
    }



}