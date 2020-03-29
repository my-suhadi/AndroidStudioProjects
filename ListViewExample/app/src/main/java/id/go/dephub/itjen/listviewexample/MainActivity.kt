package id.go.dephub.itjen.listviewexample

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.custom_alert.*
import kotlinx.android.synthetic.main.custom_list_item.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = ArrayList<CustomItem>()
        items.add(CustomItem("Android Development", "Learn android from scratch", R.drawable.image_one))
        items.add(CustomItem("Web Design", "Design more flexible layout", R.drawable.image_two))
        items.add(CustomItem("Web Development", "Learn how to build an interactive website", R.drawable.image_three))

        val adapter = CustomAdapter(this@MainActivity, items)
        val list = findViewById<ListView>(R.id.lv_list_view)

        list.adapter = adapter
        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val alert = Dialog(this@MainActivity)
            alert.setContentView(R.layout.custom_alert)

            val title = alert.findViewById<TextView>(R.id.tv_alert_title)
            val desc = alert.findViewById<TextView>(R.id.tv_alert_desc)
            val img = alert.findViewById<ImageView>(R.id.iv_alert_image)
            val hideButton = alert.findViewById<Button>(R.id.btn_alert_close)

            val selectedItem = adapter.getItem(position)

            title.text = selectedItem!!.title
            desc.text = selectedItem.description
            img.setImageResource(selectedItem.image)

            alert.show()

            hideButton.setOnClickListener {
                alert.dismiss()
            }
        }
    }
}
