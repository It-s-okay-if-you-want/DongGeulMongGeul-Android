package com.okifwant.donggeulmonggeul_android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityTutorialMainBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.TutorialViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TutorialMainActivity : BaseActivity<ActivityTutorialMainBinding, TutorialViewModel>() {
    override val layoutId = R.layout.activity_tutorial_main
    override val viewModel : TutorialViewModel by viewModels()

    override fun init() {

    }
}