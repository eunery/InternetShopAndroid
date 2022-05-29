package com.example.domain.useCases.LogoutUseCase

import com.example.domain.repository.IAuthRepo
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val repo: IAuthRepo
): ILogoutUseCase {
    override suspend fun logout() {
        return repo.logout()
    }

}