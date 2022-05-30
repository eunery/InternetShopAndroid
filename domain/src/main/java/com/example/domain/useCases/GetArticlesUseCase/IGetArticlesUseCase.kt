package com.example.domain.useCases.GetArticlesUseCase

import com.example.domain.model.Article

interface IGetArticlesUseCase {
    suspend fun getArticles(): List<Article>
}