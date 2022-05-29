package com.example.domain.useCases.CheckLoginUseCase

import com.example.domain.repository.IAuthRepo
import javax.inject.Inject

class CheckLoginUseCase@Inject constructor (
    private val repo: IAuthRepo
): ICheckLoginUseCase {
    override suspend fun check(): Boolean {
        return repo.check()
    }

}