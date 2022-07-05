package com.example.testapp.presentation.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.testapp.R
import com.example.testapp.databinding.FragmentGameNewsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsFragment : Fragment(R.layout.fragment_game_news) {

    private val binding: FragmentGameNewsBinding by viewBinding()

    private val viewModel: NewsViewModel by viewModel()

    private val adapter = NewsPagingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsList.adapter = adapter
        initObserves()
    }

    private fun initObserves() {
        viewModel.news.observe(viewLifecycleOwner) {
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}