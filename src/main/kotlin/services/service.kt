package org.example.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.models.Book
import java.io.File

fun loadBookList(): MutableList<Book> {
    var bookList: MutableList<Book>
    val gson = Gson()
    val jsonString = File("src/main/resources/books.json").readText()
    //line 15 converts 'List<Book>' into an explicit Class using Gson
    //TypeToken so 'gson.fromJson' method can be called correctly
    val listType = object : TypeToken<List<Book>>() {}.type
    bookList = gson.fromJson(jsonString, listType)

    return bookList
}

