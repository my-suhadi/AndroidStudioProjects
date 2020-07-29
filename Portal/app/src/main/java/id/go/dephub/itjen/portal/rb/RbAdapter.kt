package id.go.dephub.itjen.portal.rb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.rb.model.RbModel

class RbAdapter(_dataRb: List<RbModel>, _cx: Context, _v: View): RecyclerView.Adapter<RbAdapter.RbViewHolder>() {
    private val dataRb = _dataRb
    private val cx = _cx
    private val v = _v

    class RbViewHolder(itemToView: View): RecyclerView.ViewHolder(itemToView){
        internal val titleRb = itemToView.findViewById<TextView>(R.id.tv_title_rb)
        internal val itemRb = itemToView.findViewById<RelativeLayout>(R.id.item_rb)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RbViewHolder {
        val layout = LayoutInflater.from(cx).inflate(R.layout.item_rb, parent, false)
        return RbViewHolder(layout)
    }

    override fun getItemCount() = dataRb.size

    override fun onBindViewHolder(holder: RbViewHolder, position: Int) {
        holder.titleRb.text = dataRb[position].title
        holder.itemRb.setOnClickListener {
            val bundle = bundleOf("rbDetailUrl" to dataRb[position].url)
            Navigation.findNavController(v).navigate(R.id.action_nav_rb_to_rbDetailViewer, bundle)
        }
    }
}