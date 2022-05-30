package com.example.data.repository

import com.example.domain.model.Cart
import com.example.domain.repository.ICartRepo
import com.example.network.retrofit.ApiProvider
import com.example.network.retrofit.models.CartDto
import javax.inject.Inject

class CartRepo @Inject constructor(
    private val apiProvider: ApiProvider
):ICartRepo {
    override suspend fun getCart(): List<Cart> {
        val fromApi = apiProvider.getApi().getCart()
        return cartDtoMapToCart(fromApi)
    }

    override suspend fun putCart() {
        TODO("Not yet implemented")
    }

    private fun cartDtoMapToCart(cartDto: CartDto): List<Cart>{
        return cartDto.data!!.items.map {
            Cart(
                ID = it.ID,
                User_ID = it.User_ID,
                Product_ID = it.Product_ID,
                Shop_ID = it.Shop_ID,
                Counts = it.Counts,
                Category_ID = it.Category_ID,
                Name = it.Name,
                Price = it.Price,
                Hash = it.Hash,
                Link = it.Link,
                Description = it.Description,
                City_ID = it.City_ID,
                Street = it.Street,
                Building = it.Building,
                Corpus = it.Corpus,
                CityName = it.CityName,
            )
        }

    }
}
