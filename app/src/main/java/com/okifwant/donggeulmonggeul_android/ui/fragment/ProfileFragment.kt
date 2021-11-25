package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.adapter.MainNewAdapter
import com.okifwant.donggeulmonggeul_android.adapter.ProfileAdapter
import com.okifwant.donggeulmonggeul_android.data.model.auth.Post
import com.okifwant.donggeulmonggeul_android.data.model.newpop.Data
import com.okifwant.donggeulmonggeul_android.databinding.FragmentMainBinding
import com.okifwant.donggeulmonggeul_android.databinding.FragmentProfileBinding
import com.okifwant.donggeulmonggeul_android.ui.activity.MyInformationSetMainActivity
import com.okifwant.donggeulmonggeul_android.ui.activity.PostActivity
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import com.okifwant.donggeulmonggeul_android.wiget.extension.showVertical
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InF3ZXIxMjM0IiwiaWF0IjoxNjM3ODU5NjM2LCJleHAiOjE2Mzc5NDYwMzYsInN1YiI6InRva2VuIn0.lKdKm3fFORLpXsNw8S3_uJZx8kmxy1n72dQ5_udjsGk"
    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding : FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)        // Inflate the layout for this fragment

        binding.fragment = this
        userPost()
        getAuth()

        viewModel.auth.observe(viewLifecycleOwner){
            binding.text = it
            postList()
            userPost()
        }



        return binding.root
    }


    fun startPost() {
        val postIntent = Intent(requireActivity(), MyInformationSetMainActivity::class.java)
        startActivity(postIntent)
    }

    fun getAuth(){
        lifecycleScope.launch{

            with(viewModel){

                lifecycleScope.launch {

                    viewModel.getAuth(token)
                }

            }
        }
    }

    fun postList(): List<Post>? {
        Log.d("safddfs",viewModel.auth.value?.data.toString())
        return viewModel.auth.value?.data?.post
    }

    fun userPost(){
        binding.profileRecyclerView.showVertical(requireContext())
        binding.profileRecyclerView.adapter = ProfileAdapter(this,postList())
    }
}