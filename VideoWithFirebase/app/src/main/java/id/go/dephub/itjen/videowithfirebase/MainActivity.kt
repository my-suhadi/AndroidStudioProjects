package id.go.dephub.itjen.videowithfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun daftarBtnClicked(v: View) {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun masukBtnClicked(v: View) {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}