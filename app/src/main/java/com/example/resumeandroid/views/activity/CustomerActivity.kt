package com.example.resumeandroid.views.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.resumeandroid.databinding.ActivityCustomerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}