package com.hse.news.network

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiService {

    private const val API = "https://newsdata.io/api/1/"

    fun create(): IApiServiceInterface {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val req = chain.request()
                val request = generateRequest(req)
                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(API)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(IApiServiceInterface::class.java)
    }

    private fun generateRequest(req: Request): Request {
        return req.newBuilder()
            .header("Content-Type", "application/json")
            .method(req.method(), req.body())
            .build()
    }

}
