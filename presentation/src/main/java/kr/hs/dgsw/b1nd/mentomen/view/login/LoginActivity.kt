package kr.hs.dgsw.b1nd.mentomen.view.login

import android.content.Intent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.b1nd.mentomen.R
import kr.hs.dgsw.b1nd.mentomen.base.BaseActivity
import kr.hs.dgsw.b1nd.mentomen.databinding.ActivityLoginBinding
import kr.hs.dgsw.b1nd.mentomen.view.login.LoginViewModel.Event
import kr.hs.dgsw.b1nd.mentomen.view.main.MainActivity
import kr.hs.dgsw.b1nd.mentomen.widget.extension.MenToMenApplication

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {
    override val viewModel: LoginViewModel by viewModels()

    override fun start() {
        with(binding) {
            btnLogin.setOnClickListener {
                mViewModel.dAuthLogin(
                    etId.text.toString(),
                    etPw.text.toString()
                )
            }
            autoLogin.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) MenToMenApplication.prefs.autoLogin = true
            }
        }
        if (MenToMenApplication.prefs.autoLogin) {
            intentToMain()
        }
    }

    private fun intentToMain() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun handleEvent(event: Event): Any {
        return when (event) {
            is Event.Location -> mViewModel.login(event.location)
            is Event.LoginSuccessEvent -> intentToMain()
        }
    }
}