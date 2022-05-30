package com.example.domain.model

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