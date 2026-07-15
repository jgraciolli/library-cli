package org.example.models

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val genre: Genre,
    val publicationYear: Int,
    var borrowed: Boolean
)

