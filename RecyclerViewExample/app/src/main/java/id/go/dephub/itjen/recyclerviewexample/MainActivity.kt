package id.go.dephub.itjen.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create custom item (design its layout)
        // create a class for the things that you need to show
        // create an adapter (for normal class)
        // fill theRecycler in our activity
        // setOnClickedListener

        val items = ArrayList<CustomItem>()
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))
        items.add(CustomItem("Android App", R.drawable.image))

        val myRecyclerView = findViewById<RecyclerView>(R.id.rv_recycler_data)
        val myAdapter = MyRecyclerAdapter(items, applicationContext)

        myRecyclerView.layoutManager = GridLayoutManager(applicationContext, 3)

        myRecyclerView.adapter = myAdapter
    }
}
