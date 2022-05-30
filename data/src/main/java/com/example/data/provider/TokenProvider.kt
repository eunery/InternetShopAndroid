package com.example.data.provider

import com.example.data.storage.IStorage
import com.example.network.retrofit.ITokenProvider
import javax.inject.Inject

class TokenProvider @Inject constructor(
    private val storage: IStorage
): ITokenProvider {
    override fun getAccessToken(): String {
        return storage.getAccessToken()?:""
    }

    override fun refreshToken(): String {
        return storage.getRefreshToken()?:""
    }
}