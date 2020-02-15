package id.go.dephub.itjen.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // simpan semua gambar kedalam variabel array
        val images = arrayOf(
            R.drawable.slide_1,
            R.drawable.slide_2,
            R.drawable.slide_3,
            R.drawable.slide_4,
            R.drawable.slide_5,
            R.drawable.slide_6,
            R.drawable.slide_7)
        var index = 0

        // fetch all of the views
        val imageSlider = findViewById<ImageView>(R.id.image_slider)
        val nextBtn = findViewById<Button>(R.id.next_btn)
        val prevBtn = findViewById<Button>(R.id.prev_btn)

        nextBtn.setOnClickListener {
            index++
            imageSlider.setImageResource(images[index])
        }
        prevBtn.setOnClickListener {  }
    }
}
