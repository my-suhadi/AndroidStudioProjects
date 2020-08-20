package id.go.dephub.itjen.portal.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.viewmodel.PostListViewModel
import kotlinx.android.synthetic.main.fragment_post_list.*

class PostListFragment : Fragment() {
    private lateinit var postViewModel: PostListViewModel
    private val postListAdapter = PostListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postViewModel = ViewModelProvider(this).get(PostListViewModel::class.java)
        postViewModel.refresh()
        postList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = postListAdapter
        }

        refreshLayout.setOnRefreshListener {
            refreshLayout.isRefreshing = false
            postList.visibility = View.GONE
            listError.visibility = View.GONE
            postViewModel.refresh()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        postViewModel.allPosts.observe(viewLifecycleOwner, Observer { allPosts ->
            allPosts.let {
                postList.visibility = View.VISIBLE
                postListAdapter.updatePostList(allPosts)
            }
        })

        postViewModel.postLoadError.observe(viewLifecycleOwner, Observer { isError ->
            isError.let {
                listError.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        postViewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading.let {
                progressBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    listError.visibility = View.GONE
                    postList.visibility = View.GONE
                }
            }
        })
    }
}