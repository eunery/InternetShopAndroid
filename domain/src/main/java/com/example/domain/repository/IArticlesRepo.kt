package com.example.domain.repository

import com.example.domain.model.Article

interface IArticlesRepo {
    suspend fun getArticles(): List<Article>
}