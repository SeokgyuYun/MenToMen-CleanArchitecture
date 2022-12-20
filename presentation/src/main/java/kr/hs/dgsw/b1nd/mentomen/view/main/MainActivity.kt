package kr.hs.dgsw.b1nd.mentomen.view.main

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.base.BaseActivity
import kr.hs.dgsw.b1nd.mentomen.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    fun hasBottomBar(hasBottomBar: Boolean = true) {
        binding.bottomNavigation.visibility = if (hasBottomBar) View.VISIBLE else View.GONE
        binding.bottomAppBar.visibility = if (hasBottomBar) View.VISIBLE else View.GONE
        binding.addButton.visibility = if (hasBottomBar) View.VISIBLE else View.GONE
    }

    override fun start() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        with(binding) {
            bottomNavigation.setupWithNavController(navHostFragment.findNavController())

            bottomNavigation.background = null

        }
    }

}