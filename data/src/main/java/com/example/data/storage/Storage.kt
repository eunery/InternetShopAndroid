package com.example.data.storage

import android.content.SharedPreferences
import javax.inject.Inject

class Storage @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : IStorage {
    override fun saveAccessToken(token: String?) {
        sharedPreferences.edit().putString("accessToken", token).apply()
    }

    override fun getAccessToken(): String? {
        return sharedPreferences.getString("accessToken", null)
    }

    override fun saveRefreshToken(token: String?) {
        sharedPreferences.edit().putString("refreshToken", token).apply()
    }

    override fun getRefreshToken(): String? {
        return sharedPreferences.getString("refreshToken", null)
    }
}