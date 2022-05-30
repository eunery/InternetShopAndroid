package com.example.domain.useCases.PutCartUseCase

interface IPutCartUseCase {
    suspend fun putCart(articleId: Int, shopId: Int, counts: Int)
}