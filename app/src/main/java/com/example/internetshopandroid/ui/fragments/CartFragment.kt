package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Cart
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentCartBinding
import com.example.internetshopandroid.ui.adapters.CartAdapter
import com.google.android.flexbox.*

class CartFragment:Fragment(
    R.layout.fragment_cart
) {
    private val binding by viewBinding(FragmentCartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    fun setAdapter() {
        val adapter = CartAdapter()
        bindToRecycler(adapter)
        adapter.submitList(listOf(
            Cart(
                id = 1,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Header",
                category = "category",
                price = 20.12,
                discount = 2300.11,
            ),
            Cart(
                id = 1,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 20000.12,
                discount = 23098089.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
            Cart(
                id = 2,
                imageLink = "https://sib.fm/storage/article/April2021/Kb1KiTYol9I62IHiyBgV.jpeg",
                title = "Ляляляляляял",
                category = "category",
                price = 2876.12,
                discount = 23097908.11,
            ),
        ))
    }

    fun bindToRecycler(adapter: CartAdapter) {
        val layoutManager = FlexboxLayoutManager(context).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexWrap = FlexWrap.WRAP

        }
        binding.cartArticleRv.layoutManager = layoutManager
        binding.cartArticleRv.adapter = adapter
    }
}