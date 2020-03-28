package id.go.dephub.itjen.codeeditor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AutoCompleteTextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var userCode: AutoCompleteTextView
    lateinit var runButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userCode = findViewById(R.id.tv_user_code)
        runButton = findViewById(R.id.btn_run)

        runButton.setOnClickListener {
            Run()
        }
    }

    private fun Run() {
        val intent = Intent(this@MainActivity, RunCodeActivity::class.java)
        intent.putExtra("code", userCode.text.toString())

        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater

        inflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_run -> {
                Run()
                return true
            }

            R.id.menu_add_html -> {
                userCode.setText(" <!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<body>\n" +
                        "\n" +
                        "<h1>My First Heading</h1>\n" +
                        "<p>My first paragraph.</p>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html> ")
                return true
            }

            R.id.menu_clear -> {
                userCode.text.clear()
                return true
            }

            R.id.menu_close -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
