package com.example.resumeandroid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.resumeandroid.R
import com.example.resumeandroid.databinding.FragmentRegisterBinding
import com.example.resumeandroid.models.bases.getValues
import com.example.resumeandroid.models.user.User
import com.example.resumeandroid.viewmodels.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding

    private val userViewModel : UserViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnRegister.setOnClickListener {
                register()
            }

            btnUpdate.setOnClickListener {
                updateUser()
            }

            btnLog.setOnClickListener {
                logUser()
            }
        }
        userViewModel.getUser().observe(viewLifecycleOwner) {
            it?.let {
                showUserInformation(it)
            }
        }
    }

    private fun logUser() {

    }

    private fun updateUser() {

    }

    /**
     * Insert user to Sqlite DB
     */
    private fun register() {
        with(binding) {
            val name = edtUserName.getValues()
            val pwd = edtPwd.getValues()
            userViewModel.insertUser(User(name, pwd))
        }
    }

    // Show user information to textview
    private fun showUserInformation(user: User) {
        binding.tvUserInformation.text = "User Name ${user.name} \n Pwd : ${user.pwd}"
    }
}