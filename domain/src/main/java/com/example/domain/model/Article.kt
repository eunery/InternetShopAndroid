package com.example.domain.model

data class Article(
    val id: Int,
    val imageLink: String,
    val title: String,
    val description: String,
    val price: Double,
    val discount: Double,
    val isFavourite: Boolean,
)
