package com.okifwant.donggeulmonggeul_android.ui

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivitySignUpBinding
import com.okifwant.donggeulmonggeul_android.dto.RegisterRequest
import com.okifwant.donggeulmonggeul_android.viewmodel.SignUpViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>() {

    override val layoutId = R.layout.activity_sign_up
    override val viewModel: SignUpViewModel by viewModels()

    var status = 1
    var empty = true

    var id = ""
    var password  = ""

    override fun init() {
        edittextTyping(binding.etId)
        edittextTyping(binding.etNickname)
        clickContinue()
        edittextTyping(binding.etPassword, binding.etCheckPassword)
    }


    private fun edittextTyping(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!binding.etId.text.isNullOrEmpty()) {
                    binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_blue))
                    empty = true
                } else {
                    binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_gray_btn))
                    empty = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun edittextTyping(editText: EditText, editText2: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (editText.text.toString().length > 5 && (editText.text.toString().length == editText2.text.toString().length)) {
                    binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_blue))
                    empty = true
                } else {
                    binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_gray_btn))
                    empty = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    fun intent(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }


    private fun clickContinue() {
        binding.ibContinueBtn.setOnClickListener {
            when (status) {
                1 -> {
                    if (!binding.etId.text.isNullOrEmpty()) {
                        binding.etId.visibility = View.GONE
                        binding.tvId.visibility = View.GONE
                        binding.ivFirstText.visibility = View.GONE

                        binding.etCheckPassword.visibility = View.VISIBLE
                        binding.etPassword.visibility = View.VISIBLE
                        binding.tvPassword.visibility = View.VISIBLE
                        binding.tvPasswordCheck.visibility = View.VISIBLE
                        binding.ivSecondText.visibility = View.VISIBLE

                        binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_gray_btn))
                        status++

                        id = binding.etId.text.toString()
                    }
                }
                2 -> {
                    if (binding.etPassword.text.toString().length > 6 && (binding.etCheckPassword.text.toString() == binding.etPassword.text.toString())) {

                        binding.etCheckPassword.visibility = View.GONE
                        binding.etPassword.visibility = View.GONE
                        binding.tvPassword.visibility = View.GONE
                        binding.tvPasswordCheck.visibility = View.GONE
                        binding.ivSecondText.visibility = View.GONE

                        binding.etNickname.visibility = View.VISIBLE
                        binding.ivNicknameText.visibility = View.VISIBLE
                        binding.tvExamNickname.visibility = View.VISIBLE
                        binding.tvNickname.visibility = View.VISIBLE

                        binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_gray_btn))
                        status++

                        password = binding.etPassword.text.toString()
                    }
                }
                3 ->{
                    if(!binding.etNickname.text.isNullOrEmpty()){
                        viewModel.register(RegisterRequest(id,password,binding.etNickname.text.toString(),"aaa"))
                        intent()

                    }


                }
            }
        }

    }


}