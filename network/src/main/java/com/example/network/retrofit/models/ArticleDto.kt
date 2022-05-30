package com.example.network.retrofit.models

import com.example.domain.model.Article

class ArticleDto(
    val status: String,
    val data: Data?,
    val text: String?,
)
{
    data class Data(
        val items: List<Article>,
        val total: Int
    )
}