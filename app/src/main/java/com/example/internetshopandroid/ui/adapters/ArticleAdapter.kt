package com.example.internetshopandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.network.retrofit.models.ArticleHomeItem
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.ui.viewHolders.HomeViewHolder
import com.example.internetshopandroid.utils.DefaultItemCallback

class ArticleAdapter: ListAdapter<
        ArticleHomeItem,
        HomeViewHolder>(DefaultItemCallback<ArticleHomeItem>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}