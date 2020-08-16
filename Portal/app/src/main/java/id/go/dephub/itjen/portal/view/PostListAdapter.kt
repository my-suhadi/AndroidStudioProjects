package id.go.dephub.itjen.portal.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.model.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostListAdapter(_postList: ArrayList<PostModel>):RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {
    private val postList = _postList

    class PostViewHolder(_itemOfView: View):RecyclerView.ViewHolder(_itemOfView) {
        internal val itemOfView = _itemOfView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(v)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemOfView.postTitle.text = postList[position].postTitle
        holder.itemOfView.postDesc.text = postList[position].postUrl
    }

    fun updatePostList(newPostList: List<PostModel>) {
        postList.clear()
        postList.addAll(newPostList)
        notifyDataSetChanged()
    }
}