package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Article
import com.example.network.retrofit.models.ArticleHomeItem
import com.example.domain.useCases.GetArticlesUseCase.GetArticlesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
): ViewModel() {
    val articleHomeItem = MutableLiveData<List<ArticleHomeItem>>(emptyList())
    val article = MutableLiveData<Article>()
    private var articleList = emptyList<Article>()

    fun refreshData(){
        viewModelScope.launch {
            articleHomeItem.value = articleMapToArticleHomeItem(getArticlesUseCase.getArticles())
        }
    }

    private fun onClick(id: Int){
        article.value = articleList.first {it.ID == id}
    }

    private fun articleMapToArticleHomeItem( article: List<Article>): List<ArticleHomeItem>{
        articleList = article
        return article.map {
            ArticleHomeItem(
                ID = it.ID,
                Name = it.Name,
                Price = it.Price,
                Hash = it.Hash,
                CategoryName = it.CategoryName,
                onClick = { onClick(it.ID) }
            )
        }
    }

}