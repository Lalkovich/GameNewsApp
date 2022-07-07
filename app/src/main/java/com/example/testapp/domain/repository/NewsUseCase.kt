package com.example.testapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.testapp.data.response.NewsResponse


class NewsUseCase(private val repository: NewsRepository ) {
    fun getPagingNews():LiveData<PagingData<NewsResponse>> = repository.getNewsPaging()
   suspend fun getVPTopGameNews(): List<NewsResponse> = repository.getVPTopNews()
}