package id.go.dephub.itjen.portal.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.databinding.ItemPostBinding
import id.go.dephub.itjen.portal.model.PostModel

class PostListAdapter(_postList: ArrayList<PostModel>) :
    RecyclerView.Adapter<PostListAdapter.PostViewHolder>(), PostClickListener {

    class PostViewHolder(_itemOfView: ItemPostBinding) : RecyclerView.ViewHolder(_itemOfView.root) {
        internal val itemOfView = _itemOfView
    }

    private val postList = _postList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v =
            DataBindingUtil.inflate<ItemPostBinding>(inflater, R.layout.item_post, parent, false)
        return PostViewHolder(v)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemOfView.itemPostingan = postList[position]
        holder.itemOfView.listener = this
    }

    fun updatePostList(newPostList: List<PostModel>) {
        postList.clear()
        postList.addAll(newPostList)
        notifyDataSetChanged()
    }

    override fun onPostClicked(v: View, postId: Int) {
        val action = PostListFragmentDirections.actionPostListFragmentToDetailPostFragment(postId)
        Navigation.findNavController(v).navigate(action)
    }
}