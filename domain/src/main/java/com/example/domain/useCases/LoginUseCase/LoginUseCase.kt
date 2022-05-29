package com.example.domain.useCases.LoginUseCase

import com.example.domain.model.LoginArgs
import com.example.domain.model.LoginDto
import com.example.domain.repository.IAuthRepo
import com.example.domain.repository.LoginResult
import javax.inject.Inject

class LoginUseCase @Inject constructor (
    private val repo: IAuthRepo
): ILoginUseCase {
    override suspend fun login(args: LoginArgs): LoginResult {
        return repo.login(args)
    }
}