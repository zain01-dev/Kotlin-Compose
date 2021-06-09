package com.example.jpcompose.data

data class Book(
    val name: String,
    val author: String
)
fun getBooksList() = listOf(
    Book("OOP", "XYZ"),
    Book("DSA", "ABC"),
    Book("PF", "ASA"),
    Book("DBA", "Amit"),
    Book("DBMS", "Mishra"),
    Book("OOAD", "Himanshu"),
    Book("Computer Architecture", "Sumit Mishra"),
    Book("Intro Java", "Amit Shekhar"),
    Book("Web Programming", "Daier Arnold"),
    Book("C++ programming", "Dr Rolfh"),
    Book("Probability & Stat", "RF Mishra") ,
    Book("Economic", "Prof Rowg Dean"),
    Book("International Affairs", "Prof Rowg Dean")
)