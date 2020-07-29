package id.go.dephub.itjen.portal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class PortalWebFragment : Fragment() {
    lateinit var webUrl : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webUrl = requireArguments().getString("UrlWebKey")!!
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portal_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val portalWebView = view.findViewById<WebView>(R.id.webview_portal)
        portalWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url!!.matches(Regex.fromLiteral("itjen.dephub.go.id"))) {
                    view?.loadUrl(url)
                } else {
                    // membuka aplikasi lain saat sebuah link diklik
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                }
                return true
            }
        }
        portalWebView.settings.builtInZoomControls = true
/*
        val htmlData = "<h2>$postTitle</h2><br/><div align=\"justify\">$postContent</div>"
        webView.loadData(htmlData, "text/html","UTF-8")
*/
        portalWebView.loadUrl(webUrl)
    }

    override fun onDestroy() {
        (activity as AppCompatActivity).supportActionBar!!.show()
        super.onDestroy()
    }
}