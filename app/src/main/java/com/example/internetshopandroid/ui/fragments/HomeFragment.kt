package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.network.retrofit.models.ArticleHomeItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentHomeBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.ui.adapters.ArticleAdapter
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
        setToolbarTitle(requireContext().getString(R.string.nav_menu_home))
        viewModel.articleHomeItem.observe(viewLifecycleOwner){
            setAdapter(it)
        }
        viewModel.article.observe(viewLifecycleOwner){
            findNavController().navigate(R.id.action_homeFragment_to_insideArticleFragment, InsideArticleFragmentArgs(it).toBundle())
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshData()
    }

    private fun setAdapter(articleHomeItem: List<ArticleHomeItem>){
        val adapter = ArticleAdapter()
        bindToRecycler(adapter)
        adapter.submitList(articleHomeItem)
    }

    private fun bindToRecycler(adapter: ArticleAdapter){
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