package com.example.internetshopandroid.ui.viewHolders

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.domain.model.Article
import com.example.domain.model.ArticleHomeItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.utils.loadDrawable

class HomeViewHolder(
    private val binding: ItemArticleBinding
):RecyclerView.ViewHolder(binding.root)
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