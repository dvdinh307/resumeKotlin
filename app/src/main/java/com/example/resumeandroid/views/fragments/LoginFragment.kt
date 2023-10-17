package com.example.resumeandroid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resumeandroid.R
import com.example.resumeandroid.databinding.FragmentLoginBinding
import com.example.resumeandroid.models.bases.showShort

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    private val controller by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnLogin.setOnClickListener {
                "Login".showShort(view.context)
            }
            btnRegister.setOnClickListener {
                controller.navigate(R.id.actionRegister)
            }
            btnShowDialog.setOnClickListener {
                controller.navigate(R.id.showBottomDialog)
            }
        }
    }

}