package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentSearchBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.ui.adapters.SearchAdapter
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.example.internetshopandroid.viewmodels.SearchViewModel
import com.google.android.flexbox.*

class SearchFragment:Fragment(
    R.layout.fragment_search
) {
    private val binding by viewBinding(FragmentSearchBinding::bind)

    private val viewModel by viewModels<SearchViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(requireContext().getString(R.string.nav_menu_search))
//        setAdapter()
    }

    private fun setAdapter() {
        val adapter = SearchAdapter()
        bindToRecycler(adapter)
        adapter.submitList(listOf())
    }

    fun bindToRecycler(adapter: SearchAdapter) {
        val layoutManager = FlexboxLayoutManager(context).apply {
            justifyContent = JustifyContent.SPACE_BETWEEN
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP

        }
        binding.searchArticleRv.layoutManager = layoutManager
        binding.searchArticleRv.adapter = adapter
    }
}