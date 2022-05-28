package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentSearchBinding
import com.example.internetshopandroid.ui.adapters.SearchAdapter
import com.google.android.flexbox.*

class SearchFragment:Fragment(
    R.layout.fragment_search
) {
    private val binding by viewBinding(FragmentSearchBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    fun setAdapter() {
        val adapter = SearchAdapter()
        bindToRecycler(adapter)
        adapter.submitList(listOf(
            Article(
                id = 1,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 20.12,
                discount = 2300.11,
                isFavourite = true
            ),
            Article(
                id = 1,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 20000.12,
                discount = 23098089.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
                isFavourite = true
            ),
        ))
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