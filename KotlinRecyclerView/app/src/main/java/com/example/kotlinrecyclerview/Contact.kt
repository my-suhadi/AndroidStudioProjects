package com.example.kotlinrecyclerview

data class Contact(val name: String, val age: Int) {
    val imageURL = "https://picsum.photos/200?random=$age"
}