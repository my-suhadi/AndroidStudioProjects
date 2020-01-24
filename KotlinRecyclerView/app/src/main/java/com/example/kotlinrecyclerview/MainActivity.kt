// https://www.youtube.com/playlist?list=PL7NYbSE8uaBBSIHntxHhyD_Fy5NUznAaD
package com.example.kotlinrecyclerview

import android.content.Context
import android.graphics.Color
import android.icu.text.AlphabeticIndex
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // cara penggunaan recyclerview
        // https://guides.codepath.com/android/Using-the-RecyclerView#using-the-recyclerview
        val contacts = createContact()
        rvContacts.adapter = ContactAdapter(this, contacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContact(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person number $i", i))
        return contacts
    }
}
