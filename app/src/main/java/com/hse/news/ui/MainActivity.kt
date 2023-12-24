package com.hse.news.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hse.news.ui.adapter.NewsAdapter
import com.hse.news.network.NewsViewModel
import com.hse.news.R

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter

        observeNews()
    }

    private fun observeNews() {
        viewModel.newsLiveData.observe(this) { newsList ->
            newsAdapter.submitList(newsList)
        }
    }

    fun onGetNewsButtonClicked(view: View) {
        val query: String = findViewById<EditText>(R.id.editText).text.toString()
        if (query.isNotEmpty()) {
            viewModel.getNews(query)
        }
    }
}
