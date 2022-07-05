package com.example.testapp.data.api

import com.example.testapp.data.response.ListResponse
import com.example.testapp.data.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("http://188.40.167.45:3001/")
    suspend fun getNews(
        @Query("page")page:Int
    ):ListResponse
}