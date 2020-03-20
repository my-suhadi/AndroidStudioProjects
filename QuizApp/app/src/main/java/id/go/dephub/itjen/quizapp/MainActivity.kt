package id.go.dephub.itjen.quizapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playVideo()
    }

    fun openActivity(v: View) {
        startActivity(Intent(this, QuizActivity::class.java))
    }

    fun playVideo() {
        val videoPlayer = findViewById<VideoView>(R.id.video_background)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_one)
        videoPlayer.setVideoURI(videoUri)
        videoPlayer.start()
    }
}
