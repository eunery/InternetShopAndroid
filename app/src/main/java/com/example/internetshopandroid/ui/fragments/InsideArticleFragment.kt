package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentInsideArticleBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.viewmodels.InsideArticleViewModel

class InsideArticleFragment: Fragment(
    R.layout.fragment_inside_article
) {
    private val binding by viewBinding(FragmentInsideArticleBinding::bind)

    private val viewModel by viewModels<InsideArticleViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
    }
}