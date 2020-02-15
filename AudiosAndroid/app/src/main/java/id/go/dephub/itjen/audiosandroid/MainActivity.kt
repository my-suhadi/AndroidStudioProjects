package id.go.dephub.itjen.audiosandroid

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playMusic(v: View) {
        val button = v as Button
        val originalBackground = button.background
        val mPlayer = MediaPlayer.create(this, resources.getIdentifier(button.tag as String, "raw", packageName))

        mPlayer.start()

        if (mPlayer.isPlaying) button.setBackgroundColor(Color.GREEN)

        btn_stop.setOnClickListener {
            mPlayer.reset()
            button.background = originalBackground
        }
    }
}