package com.okifwant.donggeulmonggeul_android.ui.activity

import android.content.Intent
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityPostDetailBinding
import com.okifwant.donggeulmonggeul_android.ui.dialog.SubSubDialog
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import gun0912.tedimagepicker.util.ToastUtil

@AndroidEntryPoint
class PostDetailActivity : BaseActivity<ActivityPostDetailBinding, PostDetailViewModel>() {
    override val layoutId: Int = R.layout.activity_post_detail
    override val viewModel: PostDetailViewModel by viewModels()

    override fun init() {
        val postId: Int = intent.getIntExtra("postId", -1)
        binding.postTb.setNavigationOnClickListener {
            finish()
        }
        viewModel.postId = postId
        viewModel.getPostDetailData()
        observeEvent()
        binding.postMoreBtn.setOnClickListener {
            if (supportFragmentManager.findFragmentByTag("subSubDialog")?.isAdded != true){
                SubSubDialog(viewModel, isPost = true).show(supportFragmentManager, "subSubDialog")
            }
        }
    }

    private fun observeEvent() {
        viewModel.run {
            message.observe(this@PostDetailActivity, {
                ToastUtil.showToast(it)
            })
            clickedCommentId.observe(this@PostDetailActivity, {
                if (supportFragmentManager.findFragmentByTag("subSubDialog")?.isAdded != true) {
                    SubSubDialog(viewModel, isPost = false).show(supportFragmentManager, "subSubDialog")
                }
            })
            startEditPost.observe(this@PostDetailActivity, {
                val intent = Intent(this@PostDetailActivity, PostActivity::class.java).apply {
                    putExtra("edit_postId", it)
                    putExtra("title",viewModel.postData.value!!.title)
                    putExtra("category", viewModel.postData.value!!.category)
                    putExtra("content", viewModel.postData.value!!.content)
                }
                startActivity(intent)
            })
        }
    }

}