package id.go.dephub.itjen.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applyAnimation(findViewById<ImageView>(R.id.animation_imgView))
        applyAnimation(findViewById<LinearLayout>(R.id.overlay_background))
    }

    fun applyAnimation(viewAnimation: View) {
        val overlay = viewAnimation.background as AnimationDrawable
        overlay.setEnterFadeDuration(3000)
        overlay.setExitFadeDuration(1000)
        overlay.start()
    }
}
