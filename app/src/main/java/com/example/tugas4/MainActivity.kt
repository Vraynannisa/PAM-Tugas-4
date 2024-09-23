package com.example.tugas4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val inputName = findViewById<EditText>(R.id.inputName)
        val inputPhone = findViewById<EditText>(R.id.inputPhone)
        val addButton = findViewById<Button>(R.id.addButton)

        val itemList = mutableListOf(
            Item(1, "Aldilla", "08123456789"),
            Item(2, "Ryan", "08987654321"),
            Item(3, "Ezekiel", "08234567890"),
            Item(4, "Raina", "08567891234"),
            Item(5, "Syabila", "08765432109"),
            Item(6, "Michael", "08876543210")
        )

        val adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        addButton.setOnClickListener {
            val name = inputName.text.toString()
            val phone = inputPhone.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val newItem = Item(itemList.size + 1, name, phone)
                itemList.add(newItem)

                adapter.notifyItemInserted(itemList.size - 1)
                recyclerView.scrollToPosition(itemList.size - 1)

                inputName.text.clear()
                inputPhone.text.clear()
            }
        }
    }
}
