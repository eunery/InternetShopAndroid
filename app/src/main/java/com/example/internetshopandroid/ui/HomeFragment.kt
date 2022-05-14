package com.example.internetshopandroid.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentHomeBinding
import com.example.internetshopandroid.ui.adapters.ArticleAdapter
import com.google.android.flexbox.*

class HomeFragment:Fragment(
    R.layout.fragment_home
) {
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArticleAdapter()
        bindToRecycler(adapter)
        adapter.submitList(listOf(
            Article(
                id = 0,
                imageLink = "https://svirtus.cdnvideo.ru/JCTXRuTk_f5YFHL2dmSnTZo8P4w=/0x0:290x290/800x0/filters:quality(100)/https://hb.bizmrg.com/cybersportru-media/e4/e4cdb05a5f1767913303efd5da02eafb.png?m=4e4c79719bfd515bd6eb927f779054a3",
                title = "random",
                description = "description",
                price = 2.12,
                discount = 23.11,
                isFavourite = true
            ),
            Article(
                id = 1,
                imageLink = "https://games.mail.ru/pre_1432x0_resize/hotbox/content_files/news/2022/01/26/d1c28756c16646898f81153f35c9d686.jpg?quality=85",
                title = "rom000000000000000000000000000000000",
                description = "description",
                price = 122121211311212000.12,
                discount = 12313231123121321321320.11,
                isFavourite = true
            ),
            Article(
                id = 2,
                imageLink = "https://games.mail.ru/pre_1432x0_resize/hotbox/content_files/news/2022/01/26/d1c28756c16646898f81153f35c9d686.jpg?quality=85",
                title = "dom",
                description = "description",
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