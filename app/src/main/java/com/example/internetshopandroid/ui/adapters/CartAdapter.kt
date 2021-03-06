package com.example.internetshopandroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.network.retrofit.models.CartItem
import com.example.internetshopandroid.databinding.ItemCartBinding
import com.example.internetshopandroid.ui.viewHolders.CartViewHolder
import com.example.internetshopandroid.utils.DefaultItemCallback

class CartAdapter: ListAdapter<
        CartItem,
        CartViewHolder>(DefaultItemCallback<CartItem>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            ItemCartBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}