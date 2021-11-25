package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.FragmentCategoryInCommunityBinding


class CategoryInCommunityFragment : Fragment() {
    private lateinit var binding : FragmentCategoryInCommunityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category_in_community, container, false)

        return binding.root
    }

}