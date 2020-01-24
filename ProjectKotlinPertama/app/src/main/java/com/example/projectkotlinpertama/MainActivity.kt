package com.example.projectkotlinpertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hitungBtn.setOnClickListener {
            val alas = editAlas.text
            val tinggi = editTinggi.text

            if (alas.isNullOrBlank()) {
                editAlas.error = "Alas tidak boleh kosong"
                editAlas.requestFocus()
            } else if (tinggi.isNullOrBlank()) {
                editTinggi.error = "Tinggi tidak boleh kosong"
                editTinggi.requestFocus()
            } else {
                hitungLuas(alas.toString().toInt(), tinggi.toString().toInt())
            }
        }
    }

    fun hitungLuas(alas: Int, tinggi: Int){
        val hasil = alas * tinggi

        textHasil.text = hasil.toString()
    }
}
