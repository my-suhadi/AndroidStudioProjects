package id.go.dephub.itjen.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submit = findViewById<Button>(R.id.submitBtn)
        val userInput = findViewById<EditText>(R.id.editText)
        val showText = findViewById<TextView>(R.id.textView)

        submit.setOnClickListener {
            showText.text = userInput.text
        }
    }
}
