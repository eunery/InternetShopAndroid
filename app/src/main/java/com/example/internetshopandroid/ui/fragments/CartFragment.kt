package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.CartItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentCartBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.ui.adapters.CartAdapter
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.google.android.flexbox.*
import kotlinx.coroutines.launch

class CartFragment:Fragment(
    R.layout.fragment_cart
) {
    private val binding by viewBinding(FragmentCartBinding::bind)

    private val viewModel by viewModels<CartViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(requireContext().getString(R.string.nav_menu_cart))
        viewModel.cartItem.observe(viewLifecycleOwner){
            setAdapter(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }


    private fun setAdapter(cartItem: List<CartItem>) {
        val adapter = CartAdapter()
        bindToRecycler(adapter)
        cartItem.map {
            adapter.submitList(listOf(
                CartItem(
                    ID = it.ID,
                    Name = it.Name,
                    Price = it.Price,
                    Hash = it.Hash,
                    Counts = it.Counts,
                    Street = it.Street,
                    Building = it.Building,
                    Corpus = it.Corpus,
                    CityName = it.CityName
                )
            ))
        }
    }

    private fun bindToRecycler(adapter: CartAdapter) {
        val layoutManager = FlexboxLayoutManager(context).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexWrap = FlexWrap.WRAP

        }
        binding.cartArticleRv.layoutManager = layoutManager
        binding.cartArticleRv.adapter = adapter
    }
}