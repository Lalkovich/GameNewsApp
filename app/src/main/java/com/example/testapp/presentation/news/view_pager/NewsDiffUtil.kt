package com.example.testapp.presentation.news.view_pager

import androidx.recyclerview.widget.DiffUtil
import com.example.testapp.data.response.NewsResponse

class NewsDiffUtil: DiffUtil.ItemCallback<NewsResponse>(){
    override fun areItemsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
        return oldItem == newItem
    }

}