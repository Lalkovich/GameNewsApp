package com.example.testapp.presentation.news

import androidx.lifecycle.ViewModel
import com.example.testapp.domain.repository.NewsUseCase


class NewsViewModel (private val newsUseCase: NewsUseCase):ViewModel() {
    val news = newsUseCase.getPagingNews()
}