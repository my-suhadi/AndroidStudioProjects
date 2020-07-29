package id.go.dephub.itjen.portal.rb

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
import id.go.dephub.itjen.portal.R

class RbDetailViewer : Fragment() {
    lateinit var rbUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rbUrl = requireArguments().getString("rbDetailUrl")!!
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rb_detail_viewer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rbWebView = view.findViewById<WebView>(R.id.web_detail_rb)
        rbWebView.webViewClient = object : WebViewClient() {
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

        rbWebView.loadUrl(rbUrl)
    }

    override fun onDestroy() {
        (activity as AppCompatActivity).supportActionBar!!.show()
        super.onDestroy()
    }
}