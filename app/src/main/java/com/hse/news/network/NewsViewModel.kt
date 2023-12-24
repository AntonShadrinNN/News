package com.hse.news.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hse.news.network.representation.NewsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val newsRepository = NewsRepository()
    private val maxDescrLen = 200
    private val _newsLiveData = MutableLiveData<List<NewsItem>>()
    val newsLiveData: LiveData<List<NewsItem>> get() = _newsLiveData

    fun getNews(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = newsRepository.getNews(query)
                if (response.status == "success") {
                    val simplifiedList = response.results.map { news ->
                        val truncatedDescription = run {
                            var truncated = news.description
                            if (truncated != null) {
                                truncated = "${news.description.take(maxDescrLen)}..."
                            }
                            truncated
                        }
                        NewsItem(news.title, truncatedDescription ?: "", news.link)
                    }
                    _newsLiveData.postValue(simplifiedList)
                } else {
                    Log.e("NewsViewModel", "Error: ${response.status}")
                }
            } catch (e: Exception) {
                Log.e("NewsViewModel", "Error fetching news", e)
            }
        }
    }
}
