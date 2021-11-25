package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseFragment
import com.okifwant.donggeulmonggeul_android.databinding.FragmentCategoryBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel

class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>() {
    override val layoutId = R.layout.fragment_category
    override val viewModel : CategoryViewModel by viewModels()


    override fun init() {

    }
}