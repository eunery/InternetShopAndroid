package com.example.network.retrofit

import com.example.domain.model.*
import com.example.network.retrofit.models.ArticleDto
import com.example.network.retrofit.models.CartDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApi
{
    @POST("api/login")
    suspend fun login(@Body args: LoginArgs): Response<LoginDto>

    // Получить все продукты
    @GET("api/products")
    suspend fun getArticles(): ArticleDto

    // Получить корзину
    @GET("api/cart")
    suspend fun getCart(): CartDto

    // Добавить в корзину
    @POST("api/cart")
    suspend fun putCart()
}