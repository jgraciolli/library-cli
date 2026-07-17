package org.example.services

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.models.Book
import java.io.File
import kotlin.collections.contains

// the program initializes bookList with the books.json content
// during the execution of the program its content may vary,
// depending on the user registering/deleting books from it
var bookList: MutableList<Book> = mutableListOf()
val paginationOptions = listOf(1, 2, 3)

fun loadBookList() {
    val gson = Gson()
    val jsonString = File("src/main/resources/books.json").readText()
    // line 15 converts 'List<Book>' into an explicit Class using Gson
    // TypeToken so 'gson.fromJson' method can be called correctly
    val listType = object : TypeToken<List<Book>>() {}.type
    bookList = gson.fromJson(jsonString, listType)
}

fun validateUserAnswer(answersList: List<Int>): Int? {
    var input = readln().toIntOrNull()

    while (input !in answersList) {
        val firstOption = answersList[0]
        val lastOption = answersList[answersList.lastIndex]
        print("Invalid option. Please select an option from $firstOption to $lastOption: ")
        input = readln().toIntOrNull()
    }

    return input
}

fun showBookCard(book: Book) {
    println("+------------------------------------------------------+")
    println("| Title: ${book.title}")
    println("| Author: ${book.author}")
    println("| Genre: ${book.genre}")
    println("| Publication year: ${book.publicationYear}")
    println("| Borrowed: ${if (book.borrowed) "yes" else "no"}")
    println("+------------------------------------------------------+")
}

fun handleBookPagination() {
    var currentPage = 1
    var lastShownPage = 0
    val lastPage = (bookList.lastIndex) / 10 + 1

    var option: Int? = 0

    while (option != 3) {
        // the condition belows prevents the function from reloading the same page it has last shown
        // when user clicks 'Previous page' and the current page is 1 or 'Next page' when its 9
        if (currentPage != lastShownPage) {
            showBookPage(currentPage)
            lastShownPage = currentPage
            println("Page $currentPage/$lastPage")
            println()
            println(" [1] Previous page ${if (currentPage == 1) "(X)" else ""}")
            println(" [2] Next page ${if (currentPage == lastPage) "(X)" else ""}")
            println(" [3] Back")
            println()
            println("-------------------------------------------------------------")
        }

        print("Select an option: ")
        option = validateUserAnswer(paginationOptions)

        when (option) {
            1 -> if (currentPage > 1) currentPage--
            2 -> if (currentPage < lastPage) currentPage++
        }
    }
}

fun showBookPage(page: Int) {
    val firstBookInPage = page * 10 - 10
    var lastBookInPage = firstBookInPage + 9
    if (lastBookInPage > bookList.lastIndex)
        lastBookInPage = bookList.lastIndex

    for (i in firstBookInPage..lastBookInPage)
        showBookCard(bookList[i])
}

