package id.go.dephub.itjen.sqliteexample

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var lists: ArrayList<SubjectCls>
    private lateinit var dbase: DBaseHelper
    private lateinit var dataCursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mulaiBtn = findViewById<Button>(R.id.btn_go)
        mulaiBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddSubjectActivity::class.java))
        }

        lists = ArrayList()
        dbase = DBaseHelper(applicationContext)
        dataCursor = dbase.ambilData

        showData()

        val adapter = SubjectAdapter(lists, applicationContext)
        val myRecyclerView = findViewById<RecyclerView>(R.id.my_recycler)

        myRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        myRecyclerView.adapter = adapter
    }

    fun showData() {
        if (dataCursor.count == 0) {
            Toast.makeText(applicationContext, "Tidak ada data", Toast.LENGTH_LONG).show()
        }
        while (dataCursor.moveToNext()) {
            lists.add(SubjectCls(dataCursor.position, dataCursor.getString(1), dataCursor.getString(2)))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        showData()
    }


}
