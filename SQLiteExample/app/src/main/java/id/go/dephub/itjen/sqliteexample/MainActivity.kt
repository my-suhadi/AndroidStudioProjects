package id.go.dephub.itjen.sqliteexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<SubjectCls>()
        items.add(SubjectCls(1, "Judul", "Deskripsi"))
        items.add(SubjectCls(2, "Judul", "Deskripsi"))
        items.add(SubjectCls(3, "Judul", "Deskripsi"))
        items.add(SubjectCls(4, "Judul", "Deskripsi"))
        items.add(SubjectCls(5, "Judul", "Deskripsi"))
        items.add(SubjectCls(6, "Judul", "Deskripsi"))
        items.add(SubjectCls(7, "Judul", "Deskripsi"))
        items.add(SubjectCls(8, "Judul", "Deskripsi"))
        items.add(SubjectCls(9, "Judul", "Deskripsi"))

        val myRecyclerView = findViewById<RecyclerView>(R.id.my_recycler)

        myRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        myRecyclerView.adapter = SubjectAdapter(items, applicationContext)
    }
}
