package id.go.dephub.itjen.imageanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class ViewsAnimation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views_animation)

        val scaleBtn = findViewById<Button>(R.id.startScale_btn)
        val fadeBtn = findViewById<Button>(R.id.fade_btn)
        val imgView = findViewById<ImageView>(R.id.scale_image)

        scaleBtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale)
            imgView.startAnimation(animation)
        }

        fadeBtn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade)
            imgView.startAnimation(animation)
        }
    }
}
