package id.go.dephub.itjen.portal.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.go.dephub.itjen.portal.R
import id.go.dephub.itjen.portal.util.getProgressDrawable
import id.go.dephub.itjen.portal.util.loadImage
import id.go.dephub.itjen.portal.viewmodel.DetailPostViewModel
import kotlinx.android.synthetic.main.fragment_detail_post.*

class DetailPostFragment : Fragment() {
    private lateinit var detailPostViewModel: DetailPostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var thePostId = 0
        arguments?.let {
            thePostId = DetailPostFragmentArgs.fromBundle(it).postId
        }

        detailPostViewModel = ViewModelProvider(this).get(DetailPostViewModel::class.java)
        detailPostViewModel.fetch(thePostId)

        observeDetailPostViewModel()
    }

    private fun observeDetailPostViewModel() {
        detailPostViewModel.postLiveData.observe(viewLifecycleOwner, Observer { post ->
            post.let {
                postTitle.text = post.title.text
                postDesc.text = post.content.text
                context?.let {
                    postImage.loadImage("https://raw.githubusercontent.com/DevTides/DogsApi/master/1.jpg", getProgressDrawable(it))
                }
            }
        })
    }
}