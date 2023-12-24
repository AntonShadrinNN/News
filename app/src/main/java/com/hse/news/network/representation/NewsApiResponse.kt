package com.hse.news.network.representation

/**
 * @field status HTTP-status
 * @field totalResults total amount of results
 * @field results List of fetched news
 */
data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val results: List<NewsItem>
)
