package id.go.dephub.itjen.portal.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.model.PostModel
import id.go.dephub.itjen.portal.util.getProgressDrawable
import id.go.dephub.itjen.portal.util.loadImage
import kotlinx.android.synthetic.main.item_post.view.*
import kotlinx.android.synthetic.main.item_post.view.postDesc
import kotlinx.android.synthetic.main.item_post.view.postImage
import kotlinx.android.synthetic.main.item_post.view.postTitle

class PostListAdapter(_postList: ArrayList<PostModel>) :
    RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {

    class PostViewHolder(_itemOfView: View) : RecyclerView.ViewHolder(_itemOfView) {
        internal val itemOfView = _itemOfView
    }

    private val postList = _postList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(v)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val postTitle = postList[position].title.rendered
        val postUrl = postList[position].link

        holder.itemOfView.postTitle.text = postTitle
        holder.itemOfView.postDesc.text = postUrl
        holder.itemOfView.setOnClickListener {
            Navigation.findNavController(it).navigate(
                PostListFragmentDirections.actionPostListFragmentToDetailPostFragment(
                    postTitle,
                    postUrl
                )
            )
        }
        holder.itemOfView.postImage.loadImage(
            "https://raw.githubusercontent.com/DevTides/DogsApi/master/1.jpg",
            getProgressDrawable(holder.itemOfView.context)
        )
    }

    fun updatePostList(newPostList: List<PostModel>) {
        postList.clear()
        postList.addAll(newPostList)
        notifyDataSetChanged()
    }
}