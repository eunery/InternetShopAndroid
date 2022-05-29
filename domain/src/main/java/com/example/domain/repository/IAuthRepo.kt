package com.example.domain.repository

import com.example.domain.model.LoginArgs
import com.example.domain.model.LoginDto

interface IAuthRepo {
    suspend fun login(args: LoginArgs): LoginResult
    suspend fun check(): Boolean
    suspend fun logout()
}

sealed class LoginResult{
    object success: LoginResult()
    data class error(val text: String): LoginResult ()
}
