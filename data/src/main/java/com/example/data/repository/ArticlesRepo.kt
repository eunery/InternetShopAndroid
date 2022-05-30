package com.example.data.repository

import com.example.domain.model.Article
import com.example.domain.repository.IArticlesRepo
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.models.ArticleDto
import javax.inject.Inject

class ArticlesRepo @Inject constructor(
    private val apiProvider: ApiProvider,
):IArticlesRepo {
    override suspend fun getArticles(): List<Article> {
        val fromApi = apiProvider.getApi().getArticles()
        return articleDtoMapToCart(fromApi)
    }

    private fun articleDtoMapToCart(articleDto: ArticleDto): List<Article>{
        return articleDto.data!!.items.map {
            Article(
                ID = it.ID,
                Category_ID = it.Category_ID,
                Name = it.Name,
                Price = it.Price,
                Hash = it.Hash,
                Link = it.Link,
                Description = it.Description,
                CategoryName = it.CategoryName
            )
        }

    }
}