package com.okifwant.donggeulmonggeul_android.ui.activity

import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.okifwant.donggeulmonggeul_android.R
import com.okifwant.donggeulmonggeul_android.base.BaseActivity
import com.okifwant.donggeulmonggeul_android.databinding.ActivityMainBinding
import com.okifwant.donggeulmonggeul_android.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    override fun init() {
        initBottomNavBar()
        observeViewModel()
    }

    private fun initBottomNavBar() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host)?.findNavController()
        val nav = binding.bottomNav as BottomNavigationView
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    private fun observeViewModel() {
        viewModel.clickEvent.observe(this, {
            when (it) {
                1 -> binding.bottomNav.visibility = View.GONE
                2 -> binding.bottomNav.visibility = View.VISIBLE
            }
        })
    }

}