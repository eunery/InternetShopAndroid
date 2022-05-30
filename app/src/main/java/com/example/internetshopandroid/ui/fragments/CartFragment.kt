package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ListAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.network.retrofit.models.CartItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentCartBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.ui.adapters.CartAdapter
import com.example.internetshopandroid.ui.viewHolders.CartViewHolder
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.google.android.flexbox.*

class CartFragment:Fragment(
    R.layout.fragment_cart
) {
    private val binding by viewBinding(FragmentCartBinding::bind)

    private val viewModel by viewModels<CartViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    private val adapter = CartAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(requireContext().getString(R.string.nav_menu_cart))
        viewModel.cartItem.observe(viewLifecycleOwner){ list ->
            setAdapter(list)
            val endedSum = list.sumOf {
                it.Counts * it.Price
            }
            binding.cartNumEndPrice.text = endedSum.toString()
            binding.cartNumEndSum.text = endedSum.toString()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }


    private fun setAdapter(cartItem: List<CartItem>) {
        bindToRecycler(adapter)
        adapter.submitList(cartItem)
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