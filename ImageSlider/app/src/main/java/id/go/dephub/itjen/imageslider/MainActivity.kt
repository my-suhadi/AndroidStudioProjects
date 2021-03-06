package id.go.dephub.itjen.imageslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
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
    lateinit var imageSlider :ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fetch all of the views
        imageSlider = findViewById(R.id.image_slider)
        val nextBtn = findViewById<Button>(R.id.next_btn)
        val prevBtn = findViewById<Button>(R.id.prev_btn)

        nextBtn.setOnClickListener {
            nextImage()
        }

        prevBtn.setOnClickListener {
            prevImage()
        }
    }

    fun nextImage() {
        index++
        if (index == images.size) index = 0
        imageSlider.setImageResource(images[index])
    }

    fun prevImage() {
        if (index == 0) index = images.size
        index--
        imageSlider.setImageResource(images[index])
    }
}
