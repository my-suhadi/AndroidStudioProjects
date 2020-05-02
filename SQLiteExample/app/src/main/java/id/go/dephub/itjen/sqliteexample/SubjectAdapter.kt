package id.go.dephub.itjen.sqliteexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectAdapter(_dataItems: ArrayList<SubjectCls>, _cx: Context) : RecyclerView.Adapter<SubjectAdapter.SubjectItemViewHolder>() {
    private val dataItems = _dataItems
    private val cx = _cx

    class SubjectItemViewHolder(_itemOfView: View) : RecyclerView.ViewHolder(_itemOfView) {
        internal val subjectID = _itemOfView.findViewById<TextView>(R.id.tv_id)
        internal val title =_itemOfView.findViewById<TextView>(R.id.tv_titel)
        internal val desc = _itemOfView.findViewById<TextView>(R.id.tv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectItemViewHolder {
        return SubjectItemViewHolder(LayoutInflater.from(this.cx).inflate(R.layout.subject_item, parent, false))
    }

    override fun getItemCount() = this.dataItems.size

    override fun onBindViewHolder(holder: SubjectItemViewHolder, position: Int) {
        holder.subjectID.text = position.toString()
        holder.title.text = this.dataItems[position].title
        holder.desc.text = this.dataItems[position].desc
    }
}