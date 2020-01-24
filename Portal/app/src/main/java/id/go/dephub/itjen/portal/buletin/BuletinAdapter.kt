// https://www.raywenderlich.com/1560485-android-recyclerview-tutorial-with-kotlin

package id.go.dephub.itjen.portal.buletin

import android.content.Intent
import android.util.Log.d
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.buletin.model.Buletin
import kotlinx.android.synthetic.main.item_buletin.view.*

class BuletinAdapter(private val listOfBuletin: List<Buletin>) : RecyclerView.Adapter<BuletinAdapter.BuletinViewHolder>() {

    // Make the class extend RecyclerView.ViewHolder, allowing the adapter to use it as as a ViewHolder.
    class BuletinViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        /*
        Add a reference to the view you’ve inflated to allow the ViewHolder to access the ImageView and TextView
        as an extension property. Kotlin Android Extensions plugin adds hidden caching functions and fields to
        prevent the constant querying of views.
        */
        private var view: View = v
        private var buletin : Buletin? = null

        // Initialize the View.OnClickListener.
        init {
            v.setOnClickListener(this)
        }

        // Implement the required method for View.OnClickListener since ViewHolders are responsible for their own event handling.
        override fun onClick(v: View?) {
            val context = itemView.context
            val readBuletinIntent = Intent(context, FragmentActivity::class.java)
            readBuletinIntent.putExtra(BULETIN_KEY, buletin)
            context.startActivity(readBuletinIntent)

            d("BuletinAdapter", "CLICK!")
        }

        fun bindBuletin(b : Buletin) {
            buletin = b
            Glide.with(view.context).load("https://picsum.photos/200?random=1901").into(view.imgBuletin)
            view.noBuletin.text = b.nomorBuletin
        }

        // Add a key for easy reference to the item launching the RecyclerView.
        companion object {
            private val BULETIN_KEY = "BULETIN"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuletinViewHolder {
        return BuletinViewHolder(
            // Run function in the Extensions.kt
            parent.inflate(R.layout.item_buletin, false)
        )
    }

    override fun getItemCount() = listOfBuletin.size

    override fun onBindViewHolder(holder: BuletinViewHolder, position: Int) {
        val itemBuletin = listOfBuletin[position]
        holder.bindBuletin(itemBuletin)
    }
}
