package com.example.internetshopandroid.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.*
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.fragmentViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentInsideArticleBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.viewmodels.InsideArticleViewModel

class InsideArticleFragment: Fragment(
    R.layout.fragment_inside_article
) {
    private val binding by viewBinding(FragmentInsideArticleBinding::bind)
    private val args by navArgs<InsideArticleFragmentArgs>()

    private val viewModel by viewModels<InsideArticleViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        setArticleData(args, requireContext())
        binding.insideArticleMinus.setOnClickListener {
            val counter = binding.insideArticleCount.text.toString()
            val count = counter.toInt()-1
            binding.insideArticleCount.text = count.toString()
        }
        binding.insideArticlePlus.setOnClickListener {
            val counter = binding.insideArticleCount.text.toString()
            val count = counter.toInt()+1
            binding.insideArticleCount.text = count.toString()
        }
        binding.insideSubmitBtn.setOnClickListener {
            viewModel.putCart(args.article, binding.insideArticleCount.text.toString().toInt())
            binding.insideSubmitBtn.text = "Добавлено в корзину"
            binding.insideSubmitBtn.isEnabled = false
        }
    }

    private fun setArticleData(args: InsideArticleFragmentArgs, context: Context) {
        binding.insidePriceNum.text = context?.getString(R.string.article_price)?.format(args.article.Price.toFloat())
        binding.insideArticleName.text = args.article.Name
        binding.insideDesciptionText.text = args.article.Description
        Glide.with(context)
            .load(args.article.Link)
            .apply(RequestOptions().centerCrop())
            .into(binding.insideCardImage)
    }
}