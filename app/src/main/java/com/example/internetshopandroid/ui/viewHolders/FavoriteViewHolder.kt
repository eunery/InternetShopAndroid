package com.example.internetshopandroid.ui.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.network.retrofit.models.ArticleHomeItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemArticleBinding

class FavoriteViewHolder(
    private val binding: ItemArticleBinding
): RecyclerView.ViewHolder(binding.root)
{
    private val context get() = binding.root.context

    fun bind(articleHomeItem: ArticleHomeItem){
        with(binding){
//          Glide.with(context)
//              .load(articleHomeItem.Hash)
//              .apply(RequestOptions().centerCrop())
//              .into(itemArticleImage)
            itemArticleHeader.text = articleHomeItem.Name
            itemArticleCategory.text = articleHomeItem.CategoryName
            itemArticlePrice.text = context.getString(R.string.article_price).format(articleHomeItem.Price.toFloat())
//          itemArticleFavourite.setImageDrawable(
//              context.loadDrawable(
//              if (article.isFavourite) R.drawable.ic_red_heart else R.drawable.ic_heart
//              )
//          )
        }
    }
}