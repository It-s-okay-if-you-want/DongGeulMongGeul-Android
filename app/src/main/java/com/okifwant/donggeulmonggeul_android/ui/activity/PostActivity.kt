package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel
import gun0912.tedimagepicker.builder.TedImagePicker

class PostActivity : BaseActivity<ActivityPostBinding, PostViewModel>() {

    override val layoutId: Int = R.layout.activity_post

    override val viewModel: PostViewModel by viewModels()

    override fun init() {
        binding.run {
            postTb.setNavigationOnClickListener {
                finish()
            }
            postImageTv.setOnClickListener {
                TedImagePicker.with(this@PostActivity)
                    .start {
                        vm.imageUri.value = it
                    }

            }
        }
    }
}