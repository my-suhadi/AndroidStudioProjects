package id.go.dephub.itjen.contacts

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ContactAdapter(private var peopleContact: ArrayList<ContactPerson>, private var cx: Context): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    class ContactViewHolder(_itemOfView: View) : RecyclerView.ViewHolder(_itemOfView) {
        internal val personLayout = _itemOfView.findViewById<RelativeLayout>(R.id.person_layout)
        internal val personCard = _itemOfView.findViewById<CardView>(R.id.person_card)
        internal val personImage = _itemOfView.findViewById<ImageView>(R.id.person_image)
        internal val personName = _itemOfView.findViewById<TextView>(R.id.person_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layout = LayoutInflater.from(cx).inflate(R.layout.person, parent, false)
        return ContactViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return peopleContact.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.personImage.setImageResource(peopleContact[position].image)
        holder.personName.text = peopleContact[position].name
        holder.personLayout.setOnClickListener {
            val alert = Dialog(cx)
            alert.setContentView(R.layout.alert)
            alert.window?.setType(WindowManager.LayoutParams.TYPE_TOAST)
            alert.setTitle("Person")

            val alertImage = alert.findViewById<CircleImageView>(R.id.alert_image)
            val alertName = alert.findViewById<TextView>(R.id.alert_tv_name)
            val alertDesc = alert.findViewById<TextView>(R.id.alert_tv_desc)
            val alertPhoneNumber = alert.findViewById<TextView>(R.id.alert_tv_phone_number)
            val alertCallButton = alert.findViewById<Button>(R.id.alert_btn_call)

            alertImage.setImageResource(peopleContact[position].image)
            alertName.text = peopleContact[position].name
            alertDesc.text = peopleContact[position].description
            alertPhoneNumber.text = peopleContact[position].phoneNumber

            alert.show()

            alertCallButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", peopleContact[position].phoneNumber, null))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(cx, intent, null)

                alert.dismiss()
            }
        }
    }
}