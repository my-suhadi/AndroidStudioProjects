package id.go.dephub.itjen.skemaraja

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.webViewClient = CustomWebViewClient(this)
        web_view.webChromeClient = CustomWebChromeClient(this)
        true.also { web_view.settings.javaScriptEnabled = it }
        web_view.settings.userAgentString = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"

        web_view.loadUrl("https://dp-wfh.dephub.go.id/")
    }
}

class CustomWebChromeClient(private val activity: Activity) : WebChromeClient() {
    override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback?) {
         callback?.invoke(origin, true, true)
    }

}

class CustomWebViewClient(private val activity: Activity) : WebViewClient() {
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
        view.settings.setGeolocationEnabled(true)
        view.loadUrl(
            "javascript:(function() {" +
                    "document.getElementsByName('nip')[0].value = '198201192008121001';" +
                    "document.getElementsByName('password')[0].value = '198201192008121001';" +
                    "document.getElementsByName('status_wfh')[0].value = '3';" +
                    "document.getElementById('timezone').value = 'Asia/Jakarta';" +
                    "document.getElementById('location_user').value = '';" +
                    "document.getElementById('location_status').value = '';" +
                    "let z = document.getElementById('btnSubmit').click();" +
                    "})()"
        )

        Toast.makeText(activity, url, Toast.LENGTH_SHORT).show()
    }
}
