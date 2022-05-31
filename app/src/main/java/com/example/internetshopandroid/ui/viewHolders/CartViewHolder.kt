package com.example.internetshopandroid.ui.viewHolders

import android.text.SpannableStringBuilder
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.network.retrofit.models.CartItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemCartBinding

class CartViewHolder(
    private val binding: ItemCartBinding
): RecyclerView.ViewHolder(binding.root){

    private val context get() = binding.root.context

    fun bind(cartItem: CartItem) {
        with(binding) {
            itemCartMinus.setOnClickListener {
                val counter = itemCartCount.text.toString()
                val count = counter.toInt()-1
                itemCartCount.text = count.toString()
                cartItem.Counts = count
            }
            itemCartPlus.setOnClickListener {
                var counter = itemCartCount.text.toString()
                val count = counter.toInt()+1
                itemCartCount.text = count.toString()
                cartItem.Counts = count
            }
            Glide.with(context)
                .load(cartItem.Link)
                .apply(RequestOptions().centerCrop())
                .into(itemCartImage)
            itemCartHeader.text = cartItem.Name
            itemCartPrice.text =
                context.getString(R.string.article_price).format(cartItem.Price.toFloat())
            val builder = SpannableStringBuilder()
            builder.append("г."+cartItem.CityName +" "+"ул."+ cartItem.Street +" "+ cartItem.Building +" "+ cartItem.Corpus)
            itemCartAddress.text = builder
            itemCartCount.text = cartItem.Counts.toString()
        }
    }
}