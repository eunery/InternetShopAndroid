package com.example.internetshopandroid.ui.viewHolders

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.domain.model.Article
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemArticleBinding
import com.example.internetshopandroid.utils.loadDrawable

class SearchViewHolder(
    private val binding: ItemArticleBinding
): RecyclerView.ViewHolder(binding.root)
{
    private val context get() = binding.root.context

    fun bind(article: Article){
        with(binding){
            Glide.with(context)
                .load(article.imageLink)
                .apply(RequestOptions().centerCrop())
                .into(itemArticleImage)
            itemArticleHeader.text = article.title
            itemArticleCategory.text = article.category
            itemArticlePrice.text = context.getString(R.string.article_price).format(article.price.toFloat())
            val discount = context.getString(R.string.article_price_strike_through).format(article.discount.toFloat())
            itemArticleFavourite.setImageDrawable(
                context.loadDrawable(
                    if (article.isFavourite) R.drawable.ic_red_heart else R.drawable.ic_heart
                )
            )
            val builder = SpannableStringBuilder(discount)
            builder.setSpan(
                StrikethroughSpan(),
                0,
                discount.length-1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            itemArticleDiscount.text = builder
        }
    }
}