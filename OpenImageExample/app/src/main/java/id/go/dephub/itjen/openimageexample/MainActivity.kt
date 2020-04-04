package id.go.dephub.itjen.openimageexample

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraButton = findViewById<Button>(R.id.btn_camera)
        cameraButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 111)
        }

        val galleryButton = findViewById<Button>(R.id.btn_gallery)
        galleryButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 112)
        }

        val rateButton = findViewById<Button>(R.id.btn_rate_us)
        rateButton.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
            } catch (error:android.content.ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/store/apps/details/?id=$packageName")))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val showImage = findViewById<ImageView>(R.id.iv_image)

        when (resultCode) {
            111 -> {
                val imageBitmap = data!!.extras!!.get("data") as Bitmap
                showImage.setImageBitmap(imageBitmap)
            }

            112 -> {
                val imageUri = data!!.data
                showImage.setImageURI(imageUri)
            }

            else -> {
                d("onActivityResult Error", resultCode.toString())
            }
        }
    }
}
