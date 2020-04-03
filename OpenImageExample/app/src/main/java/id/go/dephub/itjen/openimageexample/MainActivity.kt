package id.go.dephub.itjen.openimageexample

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log.d
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openButton = findViewById<Button>(R.id.btn_open)
        openButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 111)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        d("onActivityResult", resultCode.toString())

        if (resultCode == 111) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            val showImage = findViewById<ImageView>(R.id.iv_image)

            showImage.setImageBitmap(imageBitmap)
        }
    }
}
