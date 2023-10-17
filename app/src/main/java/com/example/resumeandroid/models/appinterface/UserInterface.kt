package com.example.resumeandroid.models.appinterface

import androidx.lifecycle.LiveData
import com.example.resumeandroid.models.user.User

interface UserInterface {
    fun getUser(): LiveData<User>
    fun insertUser(user: User)
    fun removeUser()
}