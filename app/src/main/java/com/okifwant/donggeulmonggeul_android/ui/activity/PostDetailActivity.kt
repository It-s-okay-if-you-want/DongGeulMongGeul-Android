package com.okifwant.donggeulmonggeul_android.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostDetailBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailActivity : BaseActivity<ActivityPostDetailBinding, PostDetailViewModel>() {
    override val layoutId: Int = R.layout.activity_post_detail
    override val viewModel: PostDetailViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)
    }


}