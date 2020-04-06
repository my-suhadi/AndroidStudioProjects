package id.go.dephub.itjen.recyclerviewexample

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(data: ArrayList<CustomItem>, private val context: Context): RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder>() {

    // create contructor
    // sehingga saat MyRecyclerViewAdapter dipanggil, konstruktor ini yang akan dijalankan
    var data: List<CustomItem>
    init {
        this.data = data
    }

    // create custom view holder
    class CustomViewHolder(itemToView: View): RecyclerView.ViewHolder(itemToView) {

        var image: ImageView
        var title: TextView
        var card: CardView

        init {
            title = itemToView.findViewById(R.id.tv_item_title)
            image = itemToView.findViewById(R.id.ci_profile_image)
            card = itemToView.findViewById(R.id.cv_card_profile)
        }
    }

    // === override for implement methods RecyclerView.Adapter ===
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutOfView = LayoutInflater.from(context).inflate(R.layout.custom_item, parent, false)

        return CustomViewHolder(layoutOfView)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.image.setImageResource(data[position].image)
        holder.title.text = data[position].title

        holder.card.setOnClickListener {
            val alertDialog = Dialog(context)
            alertDialog.setContentView(R.layout.custom_alert)
            alertDialog.window!!.setType(WindowManager.LayoutParams.TYPE_TOAST)
            alertDialog.setTitle("Alert of Android Development")

            alertDialog.findViewById<TextView>(R.id.tv_alert_label).text = data[position].title
            alertDialog.findViewById<ImageView>(R.id.ci_alert_profile).setImageResource(data[position].image)

            alertDialog.show()

            alertDialog.findViewById<Button>(R.id.btn_alert_done).setOnClickListener {
                alertDialog.dismiss()
            }
        }
    }
}