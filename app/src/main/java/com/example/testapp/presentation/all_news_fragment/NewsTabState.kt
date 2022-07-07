package com.example.testapp.presentation.all_news_fragment

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapp.presentation.news.NewsFragment

class NewsTabState(fragment:Fragment):FragmentStateAdapter(fragment) {

    private val news = listOf<Fragment>(
        NewsFragment()
    )

    override fun getItemCount(): Int {
        return news.size
    }

    override fun createFragment(position: Int): Fragment {
        return news[position]
    }

}