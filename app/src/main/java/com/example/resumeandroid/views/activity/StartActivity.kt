package com.example.resumeandroid.views.activity

import androidx.activity.viewModels
import com.example.resumeandroid.MainActivity
import com.example.resumeandroid.databinding.ActivitySplashBinding
import com.example.resumeandroid.models.bases.BaseActivity
import com.example.resumeandroid.models.bases.nextActivity
import com.example.resumeandroid.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Check if have user saved(Login before) -> Go main
 * if not -> Go login screen
 */
@AndroidEntryPoint
class StartActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    private val userViewModel: UserViewModel by viewModels()

    override fun initActionInOnCreate() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userViewModel.getUser().observe(this) { it ->
            it?.let {
                binding.tvInformation.text = "User : ${it.name} \n Pwd ; ${it.pwd}"
                runBlocking {
                    delay(2000)
                }
                this.nextActivity<MainActivity>(null)
            } ?: let { activity ->
                runBlocking {
                    delay(2000)
                }
                activity.nextActivity<LoginActivity>(null)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}