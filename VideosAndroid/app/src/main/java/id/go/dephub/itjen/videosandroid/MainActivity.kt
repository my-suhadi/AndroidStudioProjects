package id.go.dephub.itjen.videosandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playVideo(v : View) {
        val buttonClicked = findViewById<Button>(R.id.btn_cancel)
    }
}