package id.go.dephub.itjen.videosandroid

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Button
import android.widget.VideoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playVideo(v : View) {
        val buttonClicked = findViewById<Button>(v.id)

        val alert = Dialog(this)
        alert.setContentView(R.layout.custom_video)

        val playButton = alert.findViewById<Button>(R.id.btn_play)
        val pauseButton = alert.findViewById<Button>(R.id.btn_pause)
        val cancelButton = alert.findViewById<Button>(R.id.btn_cancel)
        val videoPlayer = alert.findViewById<VideoView>(R.id.vView_player)

        when (buttonClicked.id) {
            R.id.btn_video1 -> {
                val videoURI = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_one)
                videoPlayer.setVideoURI(videoURI)
                alert.show()
            }
            R.id.btn_video2 -> {
                val videoURI = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_two)
                videoPlayer.setVideoURI(videoURI)
                alert.show()
            }
            R.id.btn_video3 -> {
                val videoURI = Uri.parse("android.resource://" + packageName + "/" + R.raw.video_three)
                videoPlayer.setVideoURI(videoURI)
                alert.show()
            }
        }

        playButton.setOnClickListener {
            videoPlayer.start()
        }

        pauseButton.setOnClickListener {
            videoPlayer.pause()
        }

        cancelButton.setOnClickListener {
            alert.dismiss()
        }
    }
}