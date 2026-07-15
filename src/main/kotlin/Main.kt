package org.example

import org.example.models.Book
import org.example.services.loadBookList

fun main() {
    val bookList: MutableList<Book> = loadBookList()
}

