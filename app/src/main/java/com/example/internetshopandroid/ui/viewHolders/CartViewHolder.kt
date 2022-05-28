package com.example.internetshopandroid.ui.viewHolders

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.domain.model.Article
import com.example.domain.model.Cart
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemCartBinding

class CartViewHolder(
    private val binding: ItemCartBinding
): RecyclerView.ViewHolder(binding.root){

    private val context get() = binding.root.context

    fun bind(cart: Cart) {
        with(binding) {
            Glide.with(context)
                .load(cart.imageLink)
                .apply(RequestOptions().centerCrop())
                .into(itemCartImage)
            itemCartHeader.text = cart.title
            itemCartCategory.text = cart.category
            itemCartPrice.text =
                context.getString(R.string.article_price).format(cart.price.toFloat())
            val discount = context.getString(R.string.article_price_strike_through)
                .format(cart.discount.toFloat())
            val builder = SpannableStringBuilder(discount)
            builder.setSpan(
                StrikethroughSpan(),
                0,
                discount.length - 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            itemCartDiscount.text = builder
        }
    }
}