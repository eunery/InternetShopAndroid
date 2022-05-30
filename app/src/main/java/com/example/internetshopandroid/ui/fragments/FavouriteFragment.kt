package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentFavouriteBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.ui.adapters.FavouriteAdapter
import com.example.internetshopandroid.viewmodels.FavouriteViewModel
import com.example.internetshopandroid.viewmodels.MainViewModel
import com.google.android.flexbox.*

class FavouriteFragment:Fragment(
    R.layout.fragment_favourite
) {
    private val binding by viewBinding(FragmentFavouriteBinding::bind)

    private val viewModel by viewModels<FavouriteViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(requireContext().getString(R.string.nav_menu_favourite))
        setAdapter()
    }

    private fun setAdapter(){
        val adapter = FavouriteAdapter()
        bindToRecycler(adapter)
        adapter.submitList(
            emptyList())
    }

    private fun bindToRecycler(adapter: FavouriteAdapter){
        val layoutManager = FlexboxLayoutManager(context).apply {
            justifyContent = JustifyContent.SPACE_BETWEEN
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP

        }
        binding.favouriteArticleRv.layoutManager = layoutManager
        binding.favouriteArticleRv.adapter = adapter
    }
}