package com.okifwant.donggeulmonggeul_android.ui.post

import androidx.fragment.app.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseFragment
import com.okifwant.donggeulmonggeul_android.databinding.FragmentPostBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.post.PostViewModel

class PostFragment : BaseFragment<FragmentPostBinding, PostViewModel>() {

    override val layoutId: Int = R.layout.fragment_post
    override val viewModel: PostViewModel by viewModels()

}