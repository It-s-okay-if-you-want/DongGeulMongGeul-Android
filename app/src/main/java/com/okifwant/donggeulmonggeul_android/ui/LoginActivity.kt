package com.okifwant.donggeulmonggeul_android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityLoginBinding
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collect

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {
    override val layoutId = R.layout.activity_login
    override val viewModel: LoginViewModel by viewModels()

    override fun init() {
        liveEvent()
    }

    private fun liveEvent() {
        repeatOnStarted {
            viewModel.clickEvent.collect {
                when (it) {
                    is LoginViewModel.ClickEvent.SignUpClick -> onClickSignUp()
                }
            }
        }
    }

    private fun onClickSignUp(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}