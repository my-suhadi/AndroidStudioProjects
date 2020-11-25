package id.go.dephub.itjen.skemaraja

import android.app.Activity
import android.os.Build
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi


class CustomWebViewClient(activity: Activity) : WebViewClient() {
    private val _activity = activity

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

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        Toast.makeText(_activity, "Error! $error", Toast.LENGTH_LONG).show()
    }

    override fun onPageFinished(view: WebView, url: String?) {
        view.loadUrl(
            "javascript:(function() {" +
                    "document.getElementsByName('nip')[0].value = '198201192008121001';" +
                    "document.getElementsByName('password')[0].value = '198201192008121001';" +
                    "document.getElementsByName('status_wfh')[0].value = '3';" +
                    "document.getElementById('shift_2').checked = true;" +
                    "document.getElementById('timezone').value = 'Asia/Jakarta';" +
                    "document.getElementById('location_user').value = '';" +
                    "document.getElementById('location_status').value = '';" +
                    "setTimeout(() => { let z = document.getElementById('btnSubmit').click(); }, 500);"+
                    "setTimeout(() => { let x = document.getElementsByClassName('btn btn-primary')[0].click(); }, 1500);"+
                    "})()"
        )
        Toast.makeText(_activity, "Auto-fill Sukses", Toast.LENGTH_SHORT).show()
    }
}