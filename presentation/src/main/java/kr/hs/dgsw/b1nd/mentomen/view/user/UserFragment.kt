package kr.hs.dgsw.b1nd.mentomen.view.user

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.base.BaseFragment
import kr.hs.dgsw.b1nd.mentomen.databinding.FragmentUserBinding
import kr.hs.dgsw.b1nd.mentomen.view.home.HomeViewModel
import kr.hs.dgsw.b1nd.mentomen.view.home.PostAdapter
import kr.hs.dgsw.b1nd.mentomen.view.login.LoginActivity
import kr.hs.dgsw.b1nd.mentomen.widget.extension.MenToMenApplication
import kr.hs.dgsw.b1nd.mentomen.widget.extension.repeatOnStarted
import kr.hs.dgsw.b1nd.mentomen.view.user.UserViewModel.Event

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding, UserViewModel>(R.layout.fragment_user) {
    override val viewModel: UserViewModel by viewModels()

    override val hasBottomNav = true
    private val postAdapter: PostAdapter by lazy { PostAdapter {
            val action = UserFragmentDirections.actionUserFragmentToDetailFragment(it.postId)
            findNavController().navigate(action)
        }
    }

    override fun start() {
        repeatOnStarted { mViewModel.eventFlow.collect { event -> handleEvent(event) } }
        initObserver()
        with(mViewModel) {
            getUserInfo()
            getUserPost()
        }
        binding.apply {
            rvMyPage.adapter = postAdapter

            btnLogout.setOnClickListener {
                MenToMenApplication.prefs.autoLogin = false
                MenToMenApplication.prefs.deleteToken()
                startActivity(Intent(context, LoginActivity::class.java))
                activity?.finish()
            }
        }
    }

    override fun initObserver() = with(mViewModel) {
        collectSuccessEvent.observe(viewLifecycleOwner) {
            postAdapter.submitList(postList.value)
        }
        collectFailureEvent.observe(viewLifecycleOwner) {
            Toast.makeText(context, "정보를 불러오지 못했습니다.", Toast.LENGTH_SHORT).show()
            Log.d("ERROR", "${errorMsg.value}")
        }
    }

    private fun handleEvent(event: Event): Any {
        return when(event) {
            is Event.GetPostEvent -> postAdapter.submitList(event.postList)
            is Event.GetUserEvent ->
        }
    }
}