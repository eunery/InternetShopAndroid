package com.example.domain.model

import java.io.Serializable

data class Article(
    val ID: Int,
    val Category_ID: Int,
    val Name: String,
    val Price: Double,
    val Hash: String,
    val Link: String?,
    val Description: String,
    val CategoryName: String,
): Serializable
