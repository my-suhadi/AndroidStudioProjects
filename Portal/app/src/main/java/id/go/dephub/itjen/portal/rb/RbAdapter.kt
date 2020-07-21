package id.go.dephub.itjen.portal.rb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.rb.model.RbModel

class RbAdapter(_dataRb: List<RbModel>, _cx: Context): RecyclerView.Adapter<RbAdapter.RbViewHolder>() {
    private val dataRb = _dataRb
    private val cx = _cx

    class RbViewHolder(itemToView: View): RecyclerView.ViewHolder(itemToView){
        internal val titleRb = itemToView.findViewById<TextView>(R.id.tv_title_rb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RbViewHolder {
        val layout = LayoutInflater.from(cx).inflate(R.layout.item_rb, parent, false)
        return RbViewHolder(layout)
    }

    override fun getItemCount() = dataRb.size

    override fun onBindViewHolder(holder: RbViewHolder, position: Int) {
        holder.titleRb.text = dataRb[position].title
    }
}