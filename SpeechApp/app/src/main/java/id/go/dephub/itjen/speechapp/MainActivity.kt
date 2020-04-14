package id.go.dephub.itjen.speechapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<ItemClass>()
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))
        items.add(ItemClass(R.drawable.kucing, "kucing"))

        val mainRecyclerView = findViewById<RecyclerView>(R.id.main_recycler_view)
        val mainAdapter = ItemAdapter(items, applicationContext)

        mainRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        mainRecyclerView.adapter = mainAdapter
    }
}
