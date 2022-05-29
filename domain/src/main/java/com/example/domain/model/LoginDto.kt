package com.example.domain.model


data class LoginDto(
    val status: String,
    val data: Data?,
    val text: String?,
)
{
    data class Data(
        val access: String,
        val refresh: String,
    )
}

