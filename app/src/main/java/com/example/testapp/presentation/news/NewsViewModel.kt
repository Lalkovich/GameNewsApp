package com.example.testapp.presentation.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.response.NewsResponse
import com.example.testapp.domain.repository.NewsUseCase
import kotlinx.coroutines.launch


class NewsViewModel(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
    private val _topNews = MutableLiveData<List<NewsResponse>>()
    val topNews: LiveData<List<NewsResponse>> = _topNews

    val news = newsUseCase.getPagingNews()

    init {
        getToppestNews()
    }

    private fun getToppestNews(){
        viewModelScope.launch {
            _topNews.postValue(newsUseCase.getVPTopGameNews())
        }

    }

}