package com.example.resumeandroid.models.bases

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionInOnCreate()
    }
    // Init action in onCreate()
    abstract fun initActionInOnCreate()

}