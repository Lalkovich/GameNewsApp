package com.example.testapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.testapp.data.api.NewsApi
import com.example.testapp.data.response.NewsResponse
import com.example.testapp.domain.repository.NewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class NewsApiImpl (
    private val newsApi: NewsApi,
    private val newsPagingSource: NewsPagingSource
):NewsRepository {
    override fun getNewsPaging(): LiveData<PagingData<NewsResponse>> = Pager(
        config = PagingConfig(
            pageSize = 5,
            maxSize = 15,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {newsPagingSource}
    ).liveData

    override suspend fun getVPTopNews(): List<NewsResponse> = newsApi.getTopNews()


}