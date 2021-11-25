package com.okifwant.donggeulmonggeul_android.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.databinding.ActivityMyInformationSetMainBinding
import com.okifwant.donggeulmonggeul_android.databinding.FragmentMainBinding
import com.okifwant.donggeulmonggeul_android.databinding.FragmentMyInformationSetMainBinding
import com.okifwant.donggeulmonggeul_android.ui.dialog.ProfileDialog
import com.okifwant.donggeulmonggeul_android.ui.dialog.ProfileDogDialog
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import com.okifwant.donggeulmonggeul_android.viewmodel.ProfileViewModel
import kotlinx.coroutines.launch

class MyInformationSetMain : Fragment() {
    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6InF3ZXIxMjM0IiwiaWF0IjoxNjM3ODU5NjM2LCJleHAiOjE2Mzc5NDYwMzYsInN1YiI6InRva2VuIn0.lKdKm3fFORLpXsNw8S3_uJZx8kmxy1n72dQ5_udjsGk"
    private lateinit var binding : FragmentMyInformationSetMainBinding
    private val viewModel by activityViewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_information_set_main, container, false)

        binding.fragment = this

        binding.run {

            postLocalTv.setOnClickListener {
                    ProfileDialog(viewModel).show(fragmentManager!!.beginTransaction(), "category_dialog")
            }
            postDogTv.setOnClickListener {
                    ProfileDogDialog(viewModel).show(fragmentManager!!.beginTransaction(), "category_dialog")
            }
        }

        return binding.root

    }

    fun editProfile(){
        lifecycleScope.launch{

            with(viewModel){

                lifecycleScope.launch {
                    viewModel.editProfile(token,binding.nicknameEdittext.text.toString())
                        findNavController().navigate(R.id.action_myInformationSetMain_to_profileFragment2)
                }

            }
        }
    }



}