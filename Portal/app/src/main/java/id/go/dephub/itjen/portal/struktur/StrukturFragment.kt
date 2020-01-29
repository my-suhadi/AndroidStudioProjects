package id.go.dephub.itjen.portal.struktur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import id.go.dephub.itjen.portal.R
import kotlinx.android.synthetic.main.progress_bar.view.*
import kotlinx.android.synthetic.main.struktur_fragment.*

class StrukturFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.struktur_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutInflater.inflate(R.layout.progress_bar, struktur_layout)
        struktur_layout.progressBar.visibility = ProgressBar.VISIBLE

        val webView= view.findViewById<WebView>(R.id.webStrukturOrg)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.matches(Regex.fromLiteral("itjen.dephub.go.id")))
                    view?.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                struktur_layout.progressBar.visibility = ProgressBar.GONE
                super.onPageFinished(view, url)
            }
        }
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.loadUrl("https://itjen.dephub.go.id/struktur-organisasi/")
    }
}