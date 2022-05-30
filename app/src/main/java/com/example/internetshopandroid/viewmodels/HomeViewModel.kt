package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Article
import com.example.domain.model.ArticleHomeItem
import com.example.domain.useCases.GetArticlesUseCase.GetArticlesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
): ViewModel() {
    val articleHomeItem = MutableLiveData<List<ArticleHomeItem>>(emptyList())

    fun refreshData(){
        viewModelScope.launch {
            articleHomeItem.value = articleMapToArticleHomeItem(getArticlesUseCase.getArticles())
        }
    }

    private fun articleMapToArticleHomeItem( article: List<Article>): List<ArticleHomeItem>{
        return article.map {
            ArticleHomeItem(
                ID = it.ID,
                Name = it.Name,
                Price = it.Price,
                Hash = it.Hash,
                CategoryName = it.CategoryName
            )
        }
    }

}