package com.example.network.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Named

class RetrofitClient @Inject constructor(
    private val authInterceptor: AuthInterceptor
){
    private val client = OkHttpClient.Builder().addInterceptor(authInterceptor).build()

    fun getClient(baseUrl: String): Retrofit =
        Retrofit.Builder().client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}