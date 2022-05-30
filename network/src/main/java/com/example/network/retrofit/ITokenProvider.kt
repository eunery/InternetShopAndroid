package com.example.network.retrofit

interface ITokenProvider {
    fun getAccessToken(): String
    fun refreshToken(): String
}