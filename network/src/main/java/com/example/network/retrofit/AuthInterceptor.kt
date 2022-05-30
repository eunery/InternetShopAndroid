package com.example.network.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val tokenProvider: ITokenProvider
):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer "+ tokenProvider.getAccessToken()).build()
        return chain.proceed(request)
    }

}