package kr.hs.dgsw.b1nd.mentomen.view.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.base.BaseFragment
import kr.hs.dgsw.b1nd.mentomen.databinding.FragmentHomeBinding
import kr.hs.dgsw.b1nd.mentomen.view.home.HomeViewModel.Event
import kr.hs.dgsw.b1nd.mentomen.widget.extension.repeatOnStarted

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel by viewModels()

    override val hasBottomNav = true
    private lateinit var postAdapter: PostAdapter

    override fun start() {
        mViewModel.getPost()
        initPostAdapter()

        repeatOnStarted {
            mViewModel.eventFlow.collect { event -> handleEvent(event) }
        }

        binding.apply {
//            with(mViewModel) {
//                btnDesign.setOnClickListener { onClickBtn(Event.value!!.isDesignChecked, "DESIGN") }
//                btnWeb.setOnClickListener { onClickBtn(mViewModel.tagState.value!!.isWebChecked, "WEB") }
//                btnAndroid.setOnClickListener { onClickBtn(mViewModel.tagState.value!!.isAndroidChecked, "ANDROID") }
//                btnServer.setOnClickListener { onClickBtn(mViewModel.tagState.value!!.isServerChecked, "SERVER") }
//                btnIos.setOnClickListener { onClickBtn(mViewModel.tagState.value!!.isiOSChecked, "IOS") }
//            }

            refreshLayout.setOnRefreshListener {
                refreshLayout.isRefreshing = false
            }
        }
    }

    private fun initPostAdapter() {
        postAdapter = PostAdapter { post ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(post.postId)
            findNavController().navigate(action)
        }
        binding.rvHome.adapter = postAdapter
    }

    private fun handleEvent(event: Event): Any {
        return when(event) {
            is Event.TagStateEvent ->
                with(event.tagState) {
                    binding.apply {
                        btnDesign.setOnClickListener { mViewModel.onClickBtn(isDesignChecked, "DESIGN", isChecked)}
                        btnWeb.setOnClickListener { mViewModel.onClickBtn(isWebChecked, "WEB", isChecked) }
                        btnAndroid.setOnClickListener { mViewModel.onClickBtn(isAndroidChecked, "ANDROID", isChecked) }
                        btnServer.setOnClickListener { mViewModel.onClickBtn(isServerChecked, "SERVER", isChecked) }
                        btnIos.setOnClickListener { mViewModel.onClickBtn(isiOSChecked, "IOS", isChecked) }
                    }
                }
            is Event.GetPostEvent -> postAdapter.submitList(event.postList)
        }
    }

}