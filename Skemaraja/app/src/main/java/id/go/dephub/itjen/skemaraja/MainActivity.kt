package id.go.dephub.itjen.skemaraja

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.webChromeClient = CustomWebChromeClient(this)
        web_view.webViewClient = CustomWebViewClient(this)
        true.also {
            web_view.settings.javaScriptEnabled = it
        }

        web_view.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"

        web_view.loadUrl("https://dp-wfh.dephub.go.id/")

        startService(Intent(this@MainActivity, SkemaService::class.java))
    }
}