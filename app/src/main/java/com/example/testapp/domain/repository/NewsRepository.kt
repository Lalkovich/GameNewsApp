package com.example.testapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.testapp.data.response.NewsResponse

interface NewsRepository {
    fun getNewsPaging() : LiveData<PagingData<NewsResponse>>
    suspend fun getVPTopNews():List<NewsResponse>
}