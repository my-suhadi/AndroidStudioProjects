package id.go.dephub.itjen.listviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter (context: Context, data: ArrayList<CustomItem>) : ArrayAdapter<CustomItem>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_item, parent, false)

        val item = getItem(position)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        title.text = item!!.title

        val desc = itemView.findViewById<TextView>(R.id.tv_item_description)
        desc.text = item!!.description

        val img = itemView.findViewById<ImageView>(R.id.iv_item_image)
        img.setImageResource(item.image)

        return itemView
    }
}