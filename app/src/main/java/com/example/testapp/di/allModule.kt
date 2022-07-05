package com.example.testapp.di

import com.example.testapp.data.repository.NewsApiImpl
import com.example.testapp.data.repository.NewsPagingSource
import com.example.testapp.domain.repository.NewsRepository
import com.example.testapp.domain.repository.NewsUseCase
import com.example.testapp.presentation.news.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val allModule = module {
    single<NewsRepository>{NewsApiImpl(get())}
    viewModel{ NewsViewModel(get()) }
    single{NewsPagingSource(get())}
    single{ NewsUseCase(get()) }
}