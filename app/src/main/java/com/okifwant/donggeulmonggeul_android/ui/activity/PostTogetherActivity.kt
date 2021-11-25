package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostTogetherBinding
import com.okifwant.donggeulmonggeul_android.toMultipart
import com.okifwant.donggeulmonggeul_android.ui.dialog.DatePickerDialog
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostTogetherViewModel
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedimagepicker.builder.TedImagePicker

@AndroidEntryPoint
class PostTogetherActivity : BaseActivity<ActivityPostTogetherBinding, PostTogetherViewModel>() {
    override val layoutId: Int = R.layout.activity_post_together
    override val viewModel: PostTogetherViewModel by viewModels()

    override fun init() {
        binding.run {
            postTb.setNavigationOnClickListener {
                finish()
            }
            postImageTv.setOnClickListener {
                TedImagePicker.with(this@PostTogetherActivity)
                    .start {
                        viewModel.imageUri.value = it
                        viewModel.postImage(it.toMultipart(this@PostTogetherActivity))
                    }
            }
            postCategoryTv.setOnClickListener {
                if (supportFragmentManager.findFragmentByTag("category_dialog")?.isAdded != true){
                    DatePickerDialog(viewModel).show(supportFragmentManager, "category_dialog")
                }
            }
        }
    }
}