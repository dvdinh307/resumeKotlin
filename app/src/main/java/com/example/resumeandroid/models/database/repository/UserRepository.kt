package com.example.resumeandroid.models.database.repository

import androidx.lifecycle.LiveData
import com.example.resumeandroid.models.appinterface.UserInterface
import com.example.resumeandroid.models.database.dao.UserDao
import com.example.resumeandroid.models.user.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Declare function interact with UserDao
 */
@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) : UserInterface {
    suspend fun removeAllUser() = userDao.removeUser()
    override fun getUser(): LiveData<User> = userDao.getUser()
    override fun insertUser(user: User) = userDao.insertUser(user)
    override fun removeUser() = userDao.removeUser()
}