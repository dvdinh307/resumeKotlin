package com.example.resumeandroid.views.activity

import com.example.resumeandroid.databinding.ActivityLoginBinding
import com.example.resumeandroid.models.appinterface.UserInterface
import com.example.resumeandroid.models.bases.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var user: UserInterface

    override fun initActionInOnCreate() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}