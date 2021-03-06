package com.example.network.retrofit.models

data class CartItem(
    val ID: Int,
    val Name: String,
    val Price: Double,
    val Link: String?,
    var Counts: Int,
    val Street: String,
    val Building: String,
    val Corpus: String,
    val CityName: String,
)
