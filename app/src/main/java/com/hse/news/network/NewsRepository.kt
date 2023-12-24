package com.hse.news.network

import com.hse.news.network.representation.NewsApiResponse

class NewsRepository {

    suspend fun getNews(query: String): NewsApiResponse {
        return NewsApiService.create().getNews("pub_35322c6c30375e76cd0c36ac9a71267826b8e", query)
    }
}
