package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.FragmentCategoryInCommunityBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryInCommunityViewModel


class CategoryInCommunityFragment : Fragment() {
    private val viewModel by activityViewModels<CategoryInCommunityViewModel>()
    private lateinit var binding: FragmentCategoryInCommunityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_category_in_community,
            container,
            false
        )
        Log.d("TAG", "CategoryInCommunityFragment 호출됨")
        observeViewModel()
        viewModel.getPostCategory(1)
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.getCategoryResponse.observe(this, {
            Log.d("TAG", "api 호출 성공 : ${it.body()?.data}, ${it.body()?.data.isNullOrEmpty()}")
        })

        viewModel.apiErrorEvent.observe(this, {
            Log.d("TAG", "api 호출 실패 : $it")
        })
    }

}