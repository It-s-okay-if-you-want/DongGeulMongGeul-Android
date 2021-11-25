package com.okifwant.donggeulmonggeul_android.ui

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
import com.okifwant.donggeulmonggeul_android.viewmodel.SignUpViewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel>() {

    override val layoutId = R.layout.activity_sign_up
    override val viewModel: SignUpViewModel by viewModels()

    var status = 1
    var empty = true

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
                if (editText.text.toString().length > 6 && (editText.text.toString() == editText2.text.toString())) {
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


    private fun clickContinue() {
        binding.ibContinueBtn.setOnClickListener {
            when (status) {
                1 -> {
                    if (!binding.etId.text.isNullOrEmpty()) {
                        binding.clId.visibility = View.INVISIBLE
                        binding.clPassword.visibility = View.VISIBLE
                        binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_blue))
                        status++
                    }
                }
                2 -> {
                    if (binding.etPassword.text.toString().length > 6 && (binding.etCheckPassword.text.toString() == binding.etPassword.text.toString())) {
                        binding.clPassword.visibility = View.GONE
                        binding.clNickname.visibility = View.VISIBLE
                        binding.ibContinueBtn.setImageDrawable(resources.getDrawable(R.drawable.ic_continue_blue))
                        status++
                    }
                }
            }
        }

    }


}