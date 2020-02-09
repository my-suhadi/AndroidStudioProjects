package id.go.dephub.itjen.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val _userTitle = findViewById<EditText>(R.id.userTitle)
        val _userDesc = findViewById<EditText>(R.id.userDesc)
        val _submit = findViewById<Button>(R.id.submitBtn)

        _submit.setOnClickListener {
            val _intent = Intent(this, PostActivity::class.java)
            _intent.putExtra("title", _userTitle.text.toString())
            _intent.putExtra("desc", _userDesc.text.toString())
            startActivity(_intent)
        }
    }
}