package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostBinding
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.ui.dialog.PostCategoryDialog
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedimagepicker.builder.TedImagePicker
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
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
                        viewModel.imageUri.value = it
                    }
            }
            postCategoryTv.setOnClickListener {
                PostCategoryDialog(viewModel).show(supportFragmentManager, "category_dialog")
            }
        }
    }
}