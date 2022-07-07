package com.example.testapp.data.api

import androidx.lifecycle.LiveData
import com.example.testapp.data.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("http://188.40.167.45:3001/")
    suspend fun getNews(
        @Query("page")page:Int
    ): List<NewsResponse>

    @GET("http://188.40.167.45:3001/")
   suspend fun getTopNews(
        @Query("top")top:Int = 1
    ):List<NewsResponse>
}