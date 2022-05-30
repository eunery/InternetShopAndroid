package com.example.domain.useCases.GetArticlesUseCase

import com.example.domain.model.Article
import com.example.domain.repository.IArticlesRepo
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repo: IArticlesRepo
): IGetArticlesUseCase{
    override suspend fun getArticles(): List<Article> {
        return repo.getArticles()
    }

}