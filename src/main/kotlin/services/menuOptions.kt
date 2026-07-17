package org.example.services

val listOptions = listOf(1, 2)

fun showBookList() {
    println("How would you like the list?")
    println()
    println(" [1] Paginated")
    println(" [2] Full list")
    println()
    println("-------------------------------------------------------------")
    print("Select an option: ")

    val input = validateUserAnswer(listOptions)

    when (input) {
        1 -> handleBookPagination()
        2 -> for (i in bookList.indices)
            showBookCard(bookList[i])
    }
}