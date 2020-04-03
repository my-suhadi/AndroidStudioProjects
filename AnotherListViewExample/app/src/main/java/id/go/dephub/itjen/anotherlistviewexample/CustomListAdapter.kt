package id.go.dephub.itjen.anotherlistviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListAdapter(context: Context, data: ArrayList<CustomItem>): ArrayAdapter<CustomItem>(context, 0, data) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        itemView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)

        val title = itemView.findViewById<TextView>(R.id.tv_item_title)
        val desc = itemView.findViewById<TextView>(R.id.tv_item_desc)
        val leftImage = itemView.findViewById<ImageView>(R.id.iv_left_image)
        val rightImage = itemView.findViewById<ImageView>(R.id.iv_right_image)

        val item = getItem(position)
        title.text = item!!.title
        desc.text = item!!.description
        leftImage.setImageResource(item.leftImage)
        rightImage.setImageResource(item.rightImage)

        return itemView
    }
}