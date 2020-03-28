package id.go.dephub.itjen.codeeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView

class RunCodeActivity : AppCompatActivity() {
    lateinit var webBrowser: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_code)

        webBrowser = findViewById(R.id.wv_web_browser)
        webBrowser.loadData(intent.getStringExtra("code"), "text/html; charset=utf-8", null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.code_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_enable_js -> {
                webBrowser.settings.javaScriptEnabled
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
