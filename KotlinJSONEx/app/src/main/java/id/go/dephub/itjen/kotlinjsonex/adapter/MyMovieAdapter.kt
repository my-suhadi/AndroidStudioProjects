package id.go.dephub.itjen.kotlinjsonex.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.go.dephub.itjen.kotlinjsonex.R
import id.go.dephub.itjen.kotlinjsonex.model.Movie
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>) :
    RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView =
            LayoutInflater.from(context).inflate(R.layout.layout_movie_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Picasso.get().load(movieList[position].imageurl).into(holder.ivMovie)
        holder.tvName.text = movieList[position].name
        holder.tvTeam.text = movieList[position].team
        holder.tvCreatedBy.text = movieList[position].createdby
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivMovie: ImageView
        var tvName: TextView
        var tvTeam: TextView
        var tvCreatedBy: TextView

        init {
            ivMovie = itemView.ivMovie
            tvName = itemView.tvName
            tvTeam = itemView.tvTeam
            tvCreatedBy = itemView.tvCreatedBy
        }
    }
}