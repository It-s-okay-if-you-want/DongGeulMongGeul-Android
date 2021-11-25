package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.RecyclerViewAdapter
import com.okifwant.donggeulmonggeul_android.adapter.category.GetPostCategoryRecyclerViewAdapter
import com.okifwant.donggeulmonggeul_android.databinding.FragmentCategoryInCommunityBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.CategoryInCommunityViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import com.okifwant.donggeulmonggeul_android.widget.extension.showVertical


class CategoryInCommunityFragment : Fragment() {
    private val viewModel by activityViewModels<CategoryInCommunityViewModel>()
    private lateinit var binding: FragmentCategoryInCommunityBinding
    private val mainViewModel by activityViewModels<MainViewModel>()
    private lateinit var callback: OnBackPressedCallback


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                mainViewModel.setClickEvent(2)
                findNavController().navigate(R.id.action_categoryInCommunityFragment_to_categoryFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
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
        binding.fragment = this
        viewModel.getPostCategoryList.clear()
        Log.d("TAG", "CategoryInCommunityFragment 호출됨")
        observeViewModel()
        viewModel.getPostCategory(viewModel.choiceCategory)
        return binding.root
    }

    private fun initRecyclerView(){
        binding.recyclerView.showVertical(requireContext())
        binding.recyclerView.adapter = GetPostCategoryRecyclerViewAdapter(viewModel)
    }

    private fun observeViewModel() {
        viewModel.getCategoryResponse.observe(this, {
            Log.d("TAG", "api 호출 성공 : ${it.body()?.data}, ${it.body()?.data.isNullOrEmpty()}")
            initRecyclerView()
        })

        viewModel.apiErrorEvent.observe(this, {
            Toast.makeText(requireContext(),"알수없는 오류가 발생했습니다",Toast.LENGTH_SHORT).show()
        })

        viewModel.apiNullEvent.observe(this,{
            Toast.makeText(requireContext(),"게시물이 존재하지 않습니다",Toast.LENGTH_SHORT).show()
            binding.postNull.visibility = View.VISIBLE
        })
    }

    fun clickBackEvent(view: View){
        mainViewModel.setClickEvent(2)
        this@CategoryInCommunityFragment.findNavController().popBackStack()
    }
}