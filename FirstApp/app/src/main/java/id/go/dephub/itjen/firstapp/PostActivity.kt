package id.go.dephub.itjen.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        val _showTitle = findViewById<TextView>(R.id.showTitle)
        val _showDesc = findViewById<TextView>(R.id.showDesc)

        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")

        _showTitle.text = title
        _showDesc.text = desc

        gobackBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}