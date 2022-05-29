package com.example.data.storage

interface IStorage {
    fun saveAccessToken(token: String?)
    fun getAccessToken(): String?

    fun saveRefreshToken(token: String?)
    fun getRefreshToken(): String?
}