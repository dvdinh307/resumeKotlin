package com.example.resumeandroid.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.resumeandroid.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_image)
    }
}