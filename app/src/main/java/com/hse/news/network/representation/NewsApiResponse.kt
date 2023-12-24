package com.hse.news.network.representation

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val results: List<NewsItem>
)
