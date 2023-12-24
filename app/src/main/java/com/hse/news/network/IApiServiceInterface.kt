package com.hse.news.network

import com.hse.news.network.representation.NewsApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Api Service interface
 */
interface IApiServiceInterface {

    @GET("news")
    suspend fun getNews(
        @Query("apikey") apiKey: String,
        @Query("q") query: String
    ): NewsApiResponse

}
