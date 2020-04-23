package id.go.dephub.itjen.portal.beranda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import id.go.dephub.itjen.portal.R
import kotlinx.android.synthetic.main.fragment_detail_post.*
import kotlinx.android.synthetic.main.progress_bar.*
import kotlinx.android.synthetic.main.progress_bar.view.*

class DetailPostFragment : Fragment() {

    lateinit var postLink: String
    lateinit var postContent: String
    lateinit var postTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postLink = requireArguments().getString("postLink").toString()
        postContent = requireArguments().getString("postContent").toString()
        postTitle = requireArguments().getString("postTitle").toString()
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

        layoutInflater.inflate(R.layout.progress_bar, detail_post_layout)
        detail_post_layout.progressBar.visibility = ProgressBar.VISIBLE

        val webView = view.findViewById<WebView>(R.id.webDetailPost)
        webView.webViewClient = object : WebViewClient() {
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

            override fun onPageFinished(view: WebView?, url: String?) {
                detail_post_layout.progressBar.visibility = ProgressBar.GONE
                super.onPageFinished(view, url)
            }
        }
        // webView.settings.builtInZoomControls = true
/*
        val htmlData = "<h2>$postTitle</h2><br/><div align=\"justify\">$postContent</div>"
        webView.loadData(htmlData, "text/html","UTF-8")
*/
        webView.loadUrl(postLink)
    }

    override fun onDestroy() {
        //(activity as AppCompatActivity).supportActionBar!!.show()
        super.onDestroy()
    }
}