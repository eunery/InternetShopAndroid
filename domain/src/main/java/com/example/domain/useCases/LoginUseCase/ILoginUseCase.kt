package com.example.domain.useCases.LoginUseCase

import com.example.domain.model.LoginArgs
import com.example.domain.repository.LoginResult

interface ILoginUseCase {
    suspend fun login(args: LoginArgs): LoginResult
}