package com.example.kotlinrecyclerviewex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinrecyclerviewex.models.BlogPost
import kotlinx.android.synthetic.main.layout_blog_list_item.view.*

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<BlogPost> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is BlogViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList (blogList: ArrayList<BlogPost>) {
        items = blogList
    }

    class BlogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val blogImage = itemView.blog_image
        val blogTitle = itemView.blog_title
        val blogAuthor = itemView.blog_author

        fun bind(blogPost: BlogPost) {
            blogTitle.setText(blogPost.title)
            blogAuthor.setText(blogPost.username)

            val requestOption = RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOption)
                .load(blogPost.image)
                .into(blogImage)
        }
    }
}