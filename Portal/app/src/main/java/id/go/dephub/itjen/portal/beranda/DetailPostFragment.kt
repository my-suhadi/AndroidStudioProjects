package id.go.dephub.itjen.portal.beranda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import id.go.dephub.itjen.portal.R

class DetailPostFragment : Fragment() {

    lateinit var postContent: String
    lateinit var postTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postContent = arguments!!.getString("postContent")!!
        postTitle = arguments!!.getString("postTitle")!!
        //(activity as AppCompatActivity).supportActionBar!!.hide()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = view.findViewById<WebView>(R.id.webDetailPost)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        // webView.settings.builtInZoomControls = true
        val htmlData = "<h2>$postTitle</h2><br/>$postContent"

        webView.loadData(htmlData, "text/html","UTF-8")
    }

    override fun onDestroy() {
        //(activity as AppCompatActivity).supportActionBar!!.show()
        super.onDestroy()
    }
}