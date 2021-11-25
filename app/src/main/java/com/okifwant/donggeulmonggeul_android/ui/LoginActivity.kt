package com.okifwant.donggeulmonggeul_android.ui

import android.content.Intent
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityLoginBinding
import com.okifwant.donggeulmonggeul_android.dto.LoginRequest
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.ui.activity.MainActivity
import com.okifwant.donggeulmonggeul_android.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.activity_login
    override val viewModel: LoginViewModel by viewModels()

    override fun init() {
        liveEvent()
        login()
    }

    private fun liveEvent() {
        repeatOnStarted {
            viewModel.clickEvent.collect {
                when (it) {
                    is LoginViewModel.ClickEvent.SignUpClick -> onClickSignUp()
                    is LoginViewModel.ClickEvent.Login -> loginSuccess()
                }
            }
        }
    }

    private fun loginSuccess(){
        println("실행")
        val intent = Intent(this, TutorialMainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun login(){
        binding.btnLogin.setOnClickListener {
            viewModel.login(LoginRequest(binding.etId.text.toString(),binding.etPassword.text.toString()))
        }
    }

    private fun onClickSignUp(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}