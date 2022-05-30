package com.example.internetshopandroid.ui.viewHolders

import android.text.SpannableStringBuilder
import androidx.recyclerview.widget.RecyclerView
import com.example.network.retrofit.models.CartItem
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.ItemCartBinding

class CartViewHolder(
    private val binding: ItemCartBinding
): RecyclerView.ViewHolder(binding.root){

    private val context get() = binding.root.context

    fun bind(cartItem: CartItem) {
        with(binding) {
//            Glide.with(context)
//                .load(cart.imageLink)
//                .apply(RequestOptions().centerCrop())
//                .into(itemCartImage)
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