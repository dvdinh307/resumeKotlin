package com.example.resumeandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.resumeandroid.databinding.ActivityMainBinding
import com.example.resumeandroid.models.bases.nextActivity
import com.example.resumeandroid.viewmodels.UserViewModel
import com.example.resumeandroid.views.activity.CustomerActivity
import com.example.resumeandroid.views.activity.LoadImageActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnManagerCustomer.setOnClickListener {
                this@MainActivity.nextActivity<CustomerActivity>(null)
            }

            btnClearUser.setOnClickListener {
                userViewModel.deleteAllUser()
            }
            btnLoadImage.setOnClickListener {
                this@MainActivity.nextActivity<LoadImageActivity>(null)
            }

            userViewModel.getUser().observe(this@MainActivity) {
                it?.let {
                    tvHome.text = "User ${it.name} \n pwd : ${it.pwd}"
                } ?: let {
                    tvHome.text = "User Clear"
                }
            }
        }
    }
}