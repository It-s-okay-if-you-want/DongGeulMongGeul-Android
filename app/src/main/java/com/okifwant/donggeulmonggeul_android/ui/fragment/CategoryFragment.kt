package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.content.Intent
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseFragment
import com.okifwant.donggeulmonggeul_android.databinding.FragmentCategoryBinding
import com.okifwant.donggeulmonggeul_android.ui.activity.MainActivity
import com.okifwant.donggeulmonggeul_android.ui.activity.PostActivity
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryInCommunityViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryViewModel
import javax.inject.Inject

class CategoryFragment : BaseFragment<FragmentCategoryBinding, CategoryViewModel>() {
    override val layoutId = R.layout.fragment_category
    override val viewModel : CategoryViewModel by viewModels()
    private val categoryInCommunityViewModel by activityViewModels<CategoryInCommunityViewModel>()

    @Inject
    lateinit var mainActivity: MainActivity


    override fun init() {
        binding.fragment = this
        binding.plus.setOnClickListener {
            //start post 작성
            startPost()
        }
    }

    fun startPost() {
        val postIntent = Intent(requireActivity(), PostActivity::class.java)
        startActivity(postIntent)
    }
/*    1: 기뻐요
    2: 웃겨요
    3: 슬퍼요
    4: 무서워요
    5: 여기에요
    6: 조심해요
    7: 추천해요
    8: 같이해요*/
    fun clickEvent(view: View){
        when(view.id){
            binding.happy.id -> categoryInCommunityViewModel.choiceCategory = 1
            binding.smail.id -> categoryInCommunityViewModel.choiceCategory = 2
            binding.sad.id -> categoryInCommunityViewModel.choiceCategory = 3
            binding.scary.id -> categoryInCommunityViewModel.choiceCategory = 4
            binding.here.id -> categoryInCommunityViewModel.choiceCategory = 5
            binding.meet.id -> categoryInCommunityViewModel.choiceCategory = 8
            binding.waring.id -> categoryInCommunityViewModel.choiceCategory = 6
            binding.star.id -> categoryInCommunityViewModel.choiceCategory = 7
        }
        this@CategoryFragment.findNavController().navigate(R.id.action_categoryFragment_to_categoryInCommunityFragment)
    }
}