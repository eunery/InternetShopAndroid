package com.example.domain.repository

import com.example.domain.model.Cart

interface ICartRepo {
    suspend fun getCart(): List<Cart>
    suspend fun putCart(articleId: Int, shopId: Int, counts: Int)
}