package com.example.domain.useCases.CheckLoginUseCase

interface ICheckLoginUseCase {
    suspend fun check(): Boolean
}