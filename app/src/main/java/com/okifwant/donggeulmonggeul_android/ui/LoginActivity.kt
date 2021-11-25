package com.okifwant.donggeulmonggeul_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityLoginBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.LoginViewModel

class LoginActivity :BaseActivity<ActivityLoginBinding, LoginViewModel>(){
    override val layoutId = R.layout.activity_login
    override val viewModel : LoginViewModel by viewModels()


}