package id.go.dephub.itjen.portal.beranda

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.RetrofitApiService
import id.go.dephub.itjen.portal.beranda.model.Post
import id.go.dephub.itjen.portal.beranda.model.media.Image
import kotlinx.android.synthetic.main.item_post.view.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class HomeAdapter(private val posts: List<Post>, private val onClickListener: OnClickListener) :  RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface OnClickListener {
        fun onItemClick(postLink: String, postContent: String, postTitle: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.itemView.tumbPost_progressBar.visibility = ProgressBar.VISIBLE

        val post = posts[position]

        Glide.get(holder.itemView.context).setMemoryCategory(MemoryCategory.HIGH)
        // membuat retrofit lagi karena url image yg terdapat dalam masing2 post jg berupa json
        RetrofitApiService.create().getImage(post.featuredMedia).enqueue(object : Callback<Image> {
            override fun onFailure(call: Call<Image>, t: Throwable) {
                d("HomeAdapter", "onFailure: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Image>, response: Response<Image>) {
                Glide.with(holder.itemView.context)
                    .load(response.body()!!.mediaDetails.sizes.thumbnail.sourceUrl)
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.itemView.tumbPost)
                holder.itemView.tumbPost_progressBar.visibility = ProgressBar.GONE
            }
        })

        Glide.get(holder.itemView.context).clearMemory()
        var judul = post.title.rendered
        if (judul.length > 90) {
            judul = post.title.rendered
                .slice(0..89)
                .substringBeforeLast(' ') + "....."
        }
        holder.itemView.judulPost.text = judul

        holder.itemView.setOnClickListener {
            onClickListener.onItemClick(post.link, post.content.rendered, post.title.rendered)
        }
    }
}