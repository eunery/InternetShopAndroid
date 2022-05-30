package com.example.network.retrofit.models

import com.example.domain.model.Cart

data class CartDto (
    val status: String,
    val data: Data?,
    val text: String?,
)
{
    data class Data(
        val items: List<Cart>,
        val total: Int
    )
}