package com.example.tugas4

data class Item(val id: Int, val name: String, val phone: String) {
    init {
        println("Item created with id: $id, name: $name, and phone: $phone")
    }
}
