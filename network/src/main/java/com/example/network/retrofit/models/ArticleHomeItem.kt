package com.example.network.retrofit.models

data class ArticleHomeItem (
    val ID: Int,
    val Name: String,
    val Price: Double,
    val Hash: String,
    val CategoryName: String,
    val onClick: () -> Unit,
)