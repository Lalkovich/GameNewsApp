package com.example.testapp.presentation.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testapp.R
import com.example.testapp.base.extensions.updateVisibility
import com.example.testapp.data.response.NewsResponse
import com.example.testapp.databinding.RvItemBinding

class NewsPagingAdapter :
    PagingDataAdapter<NewsResponse, NewsPagingAdapter.ViewHolder>(listItemCallback) {

    inner class ViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsResponse) {
            with(binding) {
                title.text = news.title
                url.text = news.clickUrl
                time.text = news.time

                if (news.img.isNullOrEmpty()) {
                    image.updateVisibility(false)
                } else {
                    Glide.with(itemView.context)
                        .load(news.img)
                        .apply(RequestOptions().placeholder(R.drawable.placeholder))
                        .centerCrop()
                        .into(image)
                }

                url.setOnClickListener {
                    itemView.context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(news.clickUrl)
                        )
                    )
                }
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
        getItem(position)?.let { holder.bind(it) }
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