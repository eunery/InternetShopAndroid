package com.example.network.retrofit

import javax.inject.Inject

class ApiProvider @Inject constructor(
    private val client: RetrofitClient
) {
    private val baseUrl = "http://190.115.18.146/"

    fun getApi() : IApi =
        client.getClient(baseUrl)
            .create(IApi::class.java)
}