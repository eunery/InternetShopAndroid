package com.example.internetshopandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.model.Article
import com.example.domain.model.ArticleHomeItem
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.ui.viewHolders.FavoriteViewHolder
import com.example.internetshopandroid.utils.DefaultItemCallback

class FavouriteAdapter: ListAdapter<
        ArticleHomeItem,
        FavoriteViewHolder>(DefaultItemCallback<ArticleHomeItem>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}