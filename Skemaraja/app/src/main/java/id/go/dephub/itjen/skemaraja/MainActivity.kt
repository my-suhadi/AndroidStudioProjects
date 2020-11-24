package id.go.dephub.itjen.skemaraja

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.webViewClient = CustomWebViewClient(this)
        web_view.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"
        true.also {
            web_view.settings.javaScriptEnabled = it
        }

        web_view.loadUrl("https://dp-wfh.dephub.go.id/")
    }
}

class CustomWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url: String = request?.url.toString();
        view?.loadUrl(url)
        return true
    }

    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        webView.loadUrl(url)
        return true
    }

    override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
        Toast.makeText(activity, "Error! $error", Toast.LENGTH_LONG).show()
    }

    override fun onPageFinished(view: WebView, url: String?) {
        true.also { view.settings.javaScriptEnabled = it }

//        view.loadUrl("javascript:(function() {alert(\"Tes\");})()")

        view.loadUrl(
            "javascript:(function() {" +
                    "document.getElementsByName('nip').value = '198201192008121001';" +
                    "document.getElementsByName('password').value = '198201192008121001';" +
                    "document.getElementsByName('status_wfh').value = '3';" +
                    "document.getElementById('timezone').value = 'Asia/Jakarta';" +
                    "document.getElementById('location_user').value = '';" +
                    "document.getElementById('location_status').value = '';" +
                    "let z = document.getElementById('btnSubmit').click();" +
                    "})()"
        )

        Toast.makeText(activity, url, Toast.LENGTH_SHORT).show()

//        web_view.loadUrl("javascript:(function() {document.getElementById('password').value = '198201192008121001';})()")
//        web_view.loadUrl("javascript:(function() {let z = document.getElementById('btnSubmit').click();})()");
    }
}
