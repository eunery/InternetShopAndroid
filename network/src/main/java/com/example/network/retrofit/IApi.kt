package com.example.network.retrofit

import com.example.domain.model.LoginArgs
import com.example.domain.model.LoginDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface IApi
{
    @POST("api/login")
    suspend fun login(@Body args: LoginArgs): Response<LoginDto>
}