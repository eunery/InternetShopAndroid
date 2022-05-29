package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentHomeBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.ui.adapters.ArticleAdapter
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.example.internetshopandroid.viewmodels.HomeViewModel
import com.google.android.flexbox.*

class HomeFragment:Fragment(
    R.layout.fragment_home
) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val viewModel by viewModels<HomeViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    fun setAdapter(){
        val adapter = ArticleAdapter()
        bindToRecycler(adapter)
        adapter.submitList(listOf(
            Article(
                id = 0,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2.12,
                discount = 23.11,
                isFavourite = true
            ),
            Article(
                id = 1,
                imageLink = "https://games.mail.ru/pre_1432x0_resize/hotbox/content_files/news/2022/01/26/d1c28756c16646898f81153f35c9d686.jpg?quality=85",
                title = "rom000000000000000000000000000000000",
                category = "category",
                price = 122121211311212000.12,
                discount = 12313231123121321321320.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
            Article(
                id = 2,
                imageLink = "https://upload.wikimedia.org/wikipedia/ru/e/e4/Tyler%2C_the_Creator_-_Igor.jpg",
                title = "dom",
                category = "category",
                price = 2343242324323.12,
                discount = 3.11,
                isFavourite = false
            ),
        ))
    }

    fun bindToRecycler(adapter: ArticleAdapter){
        val layoutManager = FlexboxLayoutManager(context).apply {
            justifyContent = JustifyContent.SPACE_BETWEEN
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP

        }
        binding.homeArticleRv.layoutManager = layoutManager
        binding.homeArticleRv.adapter = adapter
    }
}