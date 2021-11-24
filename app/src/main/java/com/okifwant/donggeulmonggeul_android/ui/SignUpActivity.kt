package com.okifwant.donggeulmonggeul_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivitySignUpBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.SignUpViewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>(){

    override val layoutId = R.layout.activity_sign_up
    override val viewModel: SignUpViewModel by viewModels()
}