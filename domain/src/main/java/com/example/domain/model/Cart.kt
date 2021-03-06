package com.example.domain.model

data class Cart (
    val ID: Int,
    val User_ID: Int,
    val Product_ID: Int,
    val Shop_ID: Int,
    val Counts: Int,
    val Category_ID: Int,
    val Name: String,
    val Price: Double,
    val Hash: String,
    val Link: String?,
    val Description: String,
    val City_ID: Int,
    val Street: String,
    val Building: String,
    val Corpus: String,
    val CityName: String,
)