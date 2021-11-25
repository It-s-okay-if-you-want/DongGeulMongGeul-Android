package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostTogetherBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostTogetherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostTogetherActivity : BaseActivity<ActivityPostTogetherBinding, PostTogetherViewModel>() {
    override val layoutId: Int = R.layout.activity_post_together
    override val viewModel: PostTogetherViewModel by viewModels()

}