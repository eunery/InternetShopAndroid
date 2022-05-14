package com.example.internetshopandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.model.Article
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.ui.viewHolders.ArticleHomeViewHolder
import com.example.internetshopandroid.utils.DefaultItemCallback

class ArticleAdapter: ListAdapter<
        Article,
        ArticleHomeViewHolder>(DefaultItemCallback<Article>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHomeViewHolder {
        return ArticleHomeViewHolder(ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: ArticleHomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}