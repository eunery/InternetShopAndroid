package com.example.domain.useCases.getCartUseCase

import com.example.domain.model.Cart

interface IGetCartUseCase {
    suspend fun getCart(): List<Cart>
}