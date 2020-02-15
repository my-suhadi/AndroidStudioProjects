package id.go.dephub.itjen.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationImageView = findViewById<ImageView>(R.id.animation_imgView)
        val backgroundAnimation = animationImageView.background as AnimationDrawable

        backgroundAnimation.setEnterFadeDuration(3000)
        backgroundAnimation.setExitFadeDuration(1000)
        backgroundAnimation.start()
    }
}
