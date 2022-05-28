package com.example.internetshopandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.model.Article
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.ui.viewHolders.FavoriteViewHolder
import com.example.internetshopandroid.ui.viewHolders.SearchViewHolder
import com.example.internetshopandroid.utils.DefaultItemCallback

class SearchAdapter: ListAdapter<
        Article,
        SearchViewHolder>(DefaultItemCallback<Article>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            ))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))

    }
}