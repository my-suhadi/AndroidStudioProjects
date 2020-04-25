package id.go.dephub.itjen.bottomnavigation2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(_dataItems: List<CustomItem>, _cx: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private val dataItems = _dataItems
    private val cx = _cx

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(this.cx).inflate(R.layout.custom_item, parent, false)
        return ItemViewHolder(layout)
    }

    override fun getItemCount() = this.dataItems.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemImage.setImageResource(this.dataItems[position].imgRes)
        holder.itemText.text = this.dataItems[position].name
    }

    // membuat nested class
    class ItemViewHolder(_itemOfView: View) : RecyclerView.ViewHolder(_itemOfView) {
        internal val itemLayout = _itemOfView.findViewById<RelativeLayout>(R.id.item_layout)
        internal val itemImage = _itemOfView.findViewById<ImageView>(R.id.item_img)
        internal val itemText= _itemOfView.findViewById<TextView>(R.id.item_text)
    }
}