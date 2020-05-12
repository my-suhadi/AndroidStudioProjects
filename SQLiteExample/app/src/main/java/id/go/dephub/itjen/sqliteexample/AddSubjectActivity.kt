package id.go.dephub.itjen.sqliteexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddSubjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subject)

        val dbase = DBaseHelper(applicationContext)
        val edTitle = findViewById<EditText>(R.id.ed_title)
        val edDesc = findViewById<EditText>(R.id.ed_desc)
        val simpanBtn = findViewById<Button>(R.id.btn_simpan)

        simpanBtn.setOnClickListener {
            val title = edTitle.text.toString()
            val desc = edDesc.text.toString()
            dbase.tambahData(title, desc)
            Toast.makeText(this@AddSubjectActivity, "Berhasil menambahkan $title", Toast.LENGTH_LONG).show()
            startActivity(Intent(this@AddSubjectActivity, MainActivity::class.java))
        }
    }
}
