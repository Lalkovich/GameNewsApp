package com.example.testapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.testapp.data.api.NewsApi
import com.example.testapp.data.response.NewsResponse
import retrofit2.HttpException
import java.io.IOException

class NewsPagingSource (private val newsApi:NewsApi):PagingSource<Int,NewsResponse>() {
    override fun getRefreshKey(state: PagingState<Int, NewsResponse>): Int? {
        return state.anchorPosition?.let { position->
            state.closestPageToPosition(position)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsResponse> {
        return try {
            val position = params.key ?: 1
            val response = newsApi.getNews(position)
            val news = response.news
            LoadResult.Page(
                data = news,
                prevKey = if(position == 1) null else position - 1,
                nextKey = if (news.isEmpty()) null else position + 1
            )
        }catch (e:IOException){
            LoadResult.Error(e)
        }catch (e:HttpException){
            LoadResult.Error(e)
        }
    }

}