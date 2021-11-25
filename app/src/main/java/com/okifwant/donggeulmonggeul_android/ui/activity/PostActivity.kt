package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostBinding
import com.okifwant.donggeulmonggeul_android.repeatOnStarted
import com.okifwant.donggeulmonggeul_android.toMultipart
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
                        viewModel.postImage(it.toMultipart(this@PostActivity))
                    }
            }
            postCategoryTv.setOnClickListener {
                if (supportFragmentManager.findFragmentByTag("category_dialog")?.isAdded != true){
                    PostCategoryDialog(viewModel).show(supportFragmentManager, "category_dialog")
                }
            }
            vm.done.observe(this@PostActivity, {
                Snackbar.make(binding.root, "게시하였습니다", Snackbar.LENGTH_SHORT).show()
                finish()
            })
        }
    }
}