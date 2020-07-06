package id.go.dephub.itjen.videowithfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val lesson1 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%201.mp4?alt=media&token=0c2d4f9c-7ce0-41df-88aa-066e2b5d0713"
        val lesson2 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%202.mp4?alt=media&token=2bf37150-df6f-4ca8-8499-c651f9a75b65"
        val lesson3 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%203.mp4?alt=media&token=47b8284e-0591-4be4-98ea-58a87efc48ca"
        val lesson4 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%204.mp4?alt=media&token=04626db6-f618-44b1-8b3f-c9313c78b60f"
        val lesson5 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%205.mp4?alt=media&token=e740a8a7-0327-4765-9878-f3b9bb1424fb"
        val lesson6 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%206.mp4?alt=media&token=823dfb33-d240-4c27-b33b-433369bf3648"
        val lesson7 = "https://firebasestorage.googleapis.com/v0/b/video-with-firebase.appspot.com/o/Video%20With%20Firebase%207.mp4?alt=media&token=c000c6c2-9f40-455b-a35f-5ea52b576b7f"
    }
}