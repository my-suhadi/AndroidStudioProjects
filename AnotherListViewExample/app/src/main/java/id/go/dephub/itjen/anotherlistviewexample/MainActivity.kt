package id.go.dephub.itjen.anotherlistviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Design the list item
        // Create a class for the things what you need to show
        // Create an adapter
        // Fill theListView in our activity

        val items = arrayListOf<CustomItem>()

        items.add(CustomItem("App  Development", "Learn anything and anywhere from start to the end", R.drawable.image2, R.drawable.image3))
        items.add(CustomItem("Web  Application", "Learn anything and anywhere from start to the end", R.drawable.image3, R.drawable.image4))
        items.add(CustomItem("Software Engineer", "Learn anything and anywhere from start to the end", R.drawable.image4, R.drawable.image5))
        items.add(CustomItem("Machine Learning", "Learn anything and anywhere from start to the end", R.drawable.image5, R.drawable.image1))

        val adapter = CustomListAdapter(this@MainActivity, items)

        val list = findViewById<ListView>(R.id.lv_main_list_view)
        list.adapter = adapter
    }
}
