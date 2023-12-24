package com.hse.news.network.representation

/**
 * @field title Title of news
 * @field description Description of news
 * @field link Link to original source
 */
data class NewsItem(
    val title: String,
    val description: String,
    val link: String
)
