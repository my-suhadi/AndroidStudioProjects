package id.go.dephub.itjen.speechapp

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter(_dataItems: ArrayList<ItemClass>, _cx: Context) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // define the property of ItemAdapter class
    // private hanya bisa diakses oleh method2 didalam class yang bersangkutan
    private val dataItems = _dataItems
    private val cx = _cx

    class ItemViewHolder(_itemOfView: View) : RecyclerView.ViewHolder(_itemOfView) {
        // define the property of ItemViewHolder class
        // internal bisa diakses oleh instan (dlm 1 modul) dan turunan
        internal val itemLayout = _itemOfView.findViewById<RelativeLayout>(R.id.item_layout)
        internal val itemImage = _itemOfView.findViewById<ImageView>(R.id.item_image)
        internal val itemName = _itemOfView.findViewById<TextView>(R.id.item_name)
        internal lateinit var text2Speech: TextToSpeech
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(this.cx).inflate(R.layout.item, parent, false)
        return ItemViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return dataItems.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemImage.setImageResource(this.dataItems[position].imageResource)
        holder.itemName.text = this.dataItems[position].name
        holder.itemLayout.setOnClickListener {
            val myAlert = Dialog(this.cx)
            myAlert.setContentView(R.layout.alert)
            myAlert.window!!.setType(WindowManager.LayoutParams.TYPE_TOAST)

            val alertImage = myAlert.findViewById<ImageView>(R.id.alert_image)
            alertImage.setImageResource(this.dataItems[position].imageResource)

            val alertName = myAlert.findViewById<TextView>(R.id.alert_name)
            alertName.text = this.dataItems[position].name

            val alertSpellBtn = myAlert.findViewById<Button>(R.id.alert_spell_btn)
            alertSpellBtn.setOnClickListener {
                holder.text2Speech = TextToSpeech(cx, TextToSpeech.OnInitListener { status ->
                    if (status == TextToSpeech.SUCCESS) {
                        holder.text2Speech.isLanguageAvailable(Locale.ENGLISH)
                        holder.text2Speech.speak(this.dataItems[position].name, TextToSpeech.QUEUE_FLUSH, null, null)
                    }
                })
            }

            val alertDoneBtn = myAlert.findViewById<Button>(R.id.alert_done_btn)
            alertDoneBtn.setOnClickListener{
                myAlert.dismiss()
            }

            myAlert.show()
        }

    }
}