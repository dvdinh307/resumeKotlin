package com.example.resumeandroid.models.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.resumeandroid.models.user.User

/**
 * Declare all function access to User table
 */
@Dao
interface UserDao {

    @Query("SELECT * from USER order by id ASC LIMIT 1")
    fun getUser(): LiveData<User>

    @Insert()
    fun insertUser(vararg user: User)

    @Query("DELETE FROM USER")
    fun removeUser()

//    @Update()
//    fun
}