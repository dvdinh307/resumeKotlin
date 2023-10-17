package com.example.resumeandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumeandroid.models.database.repository.UserRepository
import com.example.resumeandroid.models.user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    fun getUser(): LiveData<User> = userRepository.getUser()
    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.insertUser(user)
    }

    fun deleteAllUser() = viewModelScope.launch(Dispatchers.IO) {
        userRepository.removeAllUser()
    }
}