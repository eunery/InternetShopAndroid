package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Article
import com.example.domain.useCases.PutCartUseCase.IPutCartUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class InsideArticleViewModel @Inject constructor(
    private val putCartUseCase: IPutCartUseCase
) : ViewModel() {

    fun putCart(article: Article, count: Int){
        viewModelScope.launch {
            putCartUseCase.putCart(article.ID, 1, count)
        }
    }

}