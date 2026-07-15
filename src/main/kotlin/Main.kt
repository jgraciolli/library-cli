package org.example

import org.example.models.Book
import org.example.services.loadBookList

val menuAnswers = listOf(1, 2, 3, 4, 5, 6, 7, 8)

fun main() {
    println()
    println("=============================================================")
    println("                  LIBRARY MANAGEMENT SYSTEM")
    println("=============================================================")
    println()
    println("Welcome!")

    var option: Int? = 0

    while (option != 8) {
        option = handleMenu()

        when (option) {
            1 -> println("Still in development...")
            2 -> println("Still in development...")
            3 -> println("Still in development...")
            4 -> println("Still in development...")
            5 -> println("Still in development...")
            6 -> println("Still in development...")
            7 -> println("Still in development...")
        }

        println()
    }

    println("Shutting system down...")
}

fun handleMenu(): Int? {
    println("What would you like to do?")
    println()
    println(" [1] List Books")
    println(" [2] Borrow Book")
    println(" [3] Return Book")
    println(" [4] Search Book")
    println(" [5] Register Book")
    println(" [6] Delete Book")
    println(" [7] View Statistics")
    println(" [8] Exit")
    println()
    println("-------------------------------------------------------------")
    print("Select an option: ")

    var input = readln().toIntOrNull()

    while (input !in menuAnswers) {
        print("Invalid option. Please select an option from 1 to 8: ")
        input = readln().toIntOrNull()
    }

    return input
}

