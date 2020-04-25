package id.go.dephub.itjen.bottomnavigation2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class AndroidFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layoutInflater = inflater.inflate(R.layout.fragment_android, container, false)
        val items = ArrayList<CustomItem>()

        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))
        items.add(CustomItem(R.drawable.kucing, "kucing"))

        val rvAndroid = layoutInflater.findViewById<RecyclerView>(R.id.rv_android_fr)
        val rvAdapter = ItemAdapter(items, this.context!!)

        rvAndroid.layoutManager = GridLayoutManager(this.context, 2)
        rvAndroid.adapter = rvAdapter

        return layoutInflater
    }

}
