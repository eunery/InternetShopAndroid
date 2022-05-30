package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Cart
import com.example.network.retrofit.models.CartItem
import com.example.domain.useCases.getCartUseCase.GetCartUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase
): ViewModel() {
    val cartItem = MutableLiveData<List<CartItem>>(emptyList())

    fun refreshData(){
        viewModelScope.launch {
            cartItem.value = articleMapToArticleCartItem(getCartUseCase.getCart())
        }
    }

    private fun articleMapToArticleCartItem(cart: List<Cart>): List<CartItem>{
        return cart.map {
            CartItem(
                ID = it.ID,
                Name = it.Name,
                Price = it.Price,
                Hash = it.Hash,
                Counts = it.Counts,
                Street = it.Street,
                Building = it.Building,
                Corpus = it.Corpus,
                CityName = it.CityName,
            )
        }
    }
}