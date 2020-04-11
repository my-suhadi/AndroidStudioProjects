package id.go.dephub.itjen.contacts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var peopleContact: ArrayList<ContactPerson>, var cx: Context): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(itemOfView: View) : RecyclerView.ViewHolder(itemOfView) {
        val profileImage: ImageView = itemOfView.findViewById(R.id.profile_image)
        val profileName: TextView = itemOfView.findViewById(R.id.profile_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layout = LayoutInflater.from(cx).inflate(R.layout.custom_item, parent, false)

        return ContactViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return peopleContact.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.profileImage.setImageResource(peopleContact[position].image)
        holder.profileName.text = peopleContact[position].name
    }
}