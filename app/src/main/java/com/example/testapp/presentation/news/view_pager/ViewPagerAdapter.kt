package com.example.testapp.presentation.news.view_pager

import android.content.Intent
import android.net.Uri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.testapp.R
import com.example.testapp.core.recycler_view.BaseRecyclerViewAdapter
import com.example.testapp.core.recycler_view.BindingHolder
import com.example.testapp.data.response.NewsResponse
import com.example.testapp.databinding.ViewPagerItemBinding

class ViewPagerAdapter():BaseRecyclerViewAdapter<NewsResponse,ViewPagerItemBinding>(NewsDiffUtil()){
    override val layoutId: Int
        get() = R.layout.view_pager_item

    override fun onBindViewHolder(holder: BindingHolder<ViewPagerItemBinding>, position: Int) {
        val item = getItem(holder.absoluteAdapterPosition)
        with(holder.binding){
            title.text = item.title
            time.text = item.time
            url.text = item.clickUrl

            if (item.img.isNullOrEmpty()) {
                Glide.with(imageNews.context)
                    .load(R.drawable.placeholder)
                    .into(imageNews)
            } else {
                Glide.with(imageNews.context)
                    .load(item.img)
                    .apply(RequestOptions().placeholder(R.drawable.placeholder))
                    .centerCrop()
                    .into(imageNews)
            }

            url.setOnClickListener {
                imageNews.context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(item.clickUrl)
                    )
                )
            }
        }
    }

}


