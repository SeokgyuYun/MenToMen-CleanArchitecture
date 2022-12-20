package kr.hs.dgsw.b1nd.mentomen.view.detail

import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.b1nd.domain.model.Post
import kr.hs.dgsw.b1nd.domain.model.User
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.base.BaseFragment
import kr.hs.dgsw.b1nd.mentomen.databinding.FragmentDetailBinding
import kr.hs.dgsw.b1nd.mentomen.view.comment.CommentAdapter
import kr.hs.dgsw.b1nd.mentomen.view.detail.DetailViewModel.Event
import kr.hs.dgsw.b1nd.mentomen.widget.extension.repeatOnStarted

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail),
    PopupMenu.OnMenuItemClickListener {
    override val viewModel: DetailViewModel by viewModels()
    override val hasBottomNav = false

    private lateinit var imageAdapter: ImageAdapter
    private lateinit var commentAdapter: CommentAdapter

    private var userId: Int? = null
    private var author: Int? = null

    private val navArgs: DetailFragmentArgs by navArgs()

    override fun start() {
        with(mViewModel) {
            repeatOnStarted { eventFlow.collect { event -> handleEvent(event) } }

            getUserInfo()
            getPostByPostId(navArgs.postId)
            getComment(navArgs.postId)

            binding.apply {
                btnSend.setOnClickListener {
                    submitComment(
                        etComment.text.toString(),
                        navArgs.postId
                    )
                }
            }
        }

        binding.apply {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }
            btnMore.setOnClickListener {
                showPopup(btnMore)
            }
        }
    }

    private fun handleEvent(event: Event): Any {
        return when (event) {
            is Event.GetPostEvent -> {
                author = event.post.author
                btnVisible()
                initImageAdapter(event.post)
            }
            is Event.GetUserEvent -> {
                userId = event.userInfo.userId
                btnVisible()
                initCommentAdapter(event.userInfo)
            }
            is Event.GetCommentEvent -> {
                mViewModel.getComment(navArgs.postId)
                commentAdapter.submitList(event.commentList)
            }
            is Event.SubmitCommentEvent -> { mViewModel.getComment(navArgs.postId) }
            is Event.DeletePostEvent -> { findNavController().popBackStack() }
            is Event.DeleteCommentEvent -> { mViewModel.getComment(navArgs.postId) }
        }
    }

    private fun btnVisible() {
        if (userId != null && author != null) {
            if (userId == author) binding.btnMore.visibility = View.VISIBLE
            else binding.btnMore.visibility = View.GONE
        }
    }

    private fun initCommentAdapter(userInfo: User) {
        commentAdapter = CommentAdapter(userInfo.userId) { comment ->
            mViewModel.deleteComment(comment.commentId)
        }
        binding.rvComment.adapter = commentAdapter
    }

    private fun initImageAdapter(post: Post) {
        binding.apply {
            if (post.imgUrls.isNullOrEmpty()) viewpagerFrame.visibility = View.GONE
            else {
                viewpagerFrame.visibility = View.VISIBLE
                imageAdapter = ImageAdapter { imgUrl ->
//            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToImageZoomFragment(imgUrl))
                }
                viewpager.adapter = imageAdapter
                imageAdapter.submitList(post.imgUrls)
                wormDotsIndicator.attachTo(viewpager)
                if (post.imgUrls.size == 1) wormDotsIndicator.visibility = View.GONE
                else wormDotsIndicator.visibility = View.VISIBLE
            }
        }
    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(requireContext(), view)
        popup.menuInflater.inflate(R.menu.popub, popup.menu)
        popup.setOnMenuItemClickListener(this)
        popup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit -> {
                with(mViewModel) {
//                    val action = DetailFragmentDirections.actionDetailFragmentToEditFragment(postId = postId.value!!, content = content.value!!, tag = tag.value!!)
//                    findNavController().navigate(action)
                }
            }
            R.id.delete -> {
                mViewModel.deletePost(navArgs.postId)
            }
        }
        return item != null
    }
}

