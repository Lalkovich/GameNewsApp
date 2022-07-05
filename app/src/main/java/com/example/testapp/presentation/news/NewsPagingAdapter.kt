package com.example.testapp.presentation.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testapp.R
import com.example.testapp.data.response.NewsResponse
import com.example.testapp.databinding.RvItemBinding

class NewsPagingAdapter:PagingDataAdapter<NewsResponse,NewsPagingAdapter.ViewHolder>(
    listItemCallback) {
    class ViewHolder(private val binding:RvItemBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener {

            }
        }
        fun bind(news:NewsResponse){
            with(binding){
                title.text = news.title
                url.text = news.clickUrl
                time.text = news.time
                Glide.with(image.context)
                    .load(news.img)
                    .into(image)
            }
        }
    }
    companion object {
        val listItemCallback = object : DiffUtil.ItemCallback<NewsResponse>() {
            override fun areItemsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NewsResponse, newItem: NewsResponse): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        data?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

}