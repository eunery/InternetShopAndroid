package com.example.domain.useCases.PutCartUseCase

import com.example.domain.repository.ICartRepo
import javax.inject.Inject

class PutCartUseCase @Inject constructor(
    private val repo: ICartRepo
):IPutCartUseCase {
    override suspend fun putCart(articleId: Int, shopId: Int, counts: Int) {
        repo.putCart(articleId, shopId, counts)
    }
}