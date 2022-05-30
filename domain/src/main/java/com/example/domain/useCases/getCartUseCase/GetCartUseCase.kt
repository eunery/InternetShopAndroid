package com.example.domain.useCases.getCartUseCase

import com.example.domain.model.Cart
import com.example.domain.repository.ICartRepo
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val repo: ICartRepo
):IGetCartUseCase {
    override suspend fun getCart(): List<Cart> {
        return repo.getCart()
    }
}