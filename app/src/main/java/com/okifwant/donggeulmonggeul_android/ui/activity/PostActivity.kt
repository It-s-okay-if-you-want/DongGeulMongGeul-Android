package com.okifwant.donggeulmonggeul_android.ui.activity

import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostBinding
import com.okifwant.donggeulmonggeul_android.toMultipart
import com.okifwant.donggeulmonggeul_android.ui.dialog.PostCategoryDialog
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedimagepicker.builder.TedImagePicker
import gun0912.tedimagepicker.util.ToastUtil

@AndroidEntryPoint
class PostActivity : BaseActivity<ActivityPostBinding, PostViewModel>() {

    override val layoutId: Int = R.layout.activity_post

    override val viewModel: PostViewModel by viewModels()

    var isEdit = false
    override fun init() {
        if (intent.getIntExtra("edit_postId", -1) != -1) {
            isEdit = true
            viewModel.isEdit = isEdit
        }

        binding.run {
            if (isEdit) {
                postTitleTv.text = "게시물 수정"
                postStartBtn.text = "수정하기"
                viewModel.run {
                    title.value = intent.getStringExtra("title")
                    body.value = intent.getStringExtra("content")
                    category.value = intent.getStringExtra("category")
                }
            }
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
                if (supportFragmentManager.findFragmentByTag("category_dialog")?.isAdded != true) {
                    PostCategoryDialog(viewModel).show(supportFragmentManager, "category_dialog")
                }
            }
            viewModel.done.observe(this@PostActivity, {
                ToastUtil.showToast("게시되었습니다")
                finish()
            })
        }
    }
}