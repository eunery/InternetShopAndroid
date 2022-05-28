package com.example.network.retrofit

import com.example.domain.model.User
import retrofit2.http.GET

interface IApi
{
    @GET("user")
    suspend fun getUserInfo(): List<User>

}