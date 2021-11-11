package com.example.loop.content

import java.io.Serializable

data class Content (
    val topline: String = "",
    val headline: String = "",
    val imageURL: String = "",
    val category: Category = Category.TRAVEL,
    val description: String = "",
    val price: String = "",
    val location: String = "",
    val slides: List<String>? = null
): Serializable