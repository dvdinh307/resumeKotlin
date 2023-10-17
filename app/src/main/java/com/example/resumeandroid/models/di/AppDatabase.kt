package com.example.resumeandroid.models.di

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.resumeandroid.models.database.DatabaseString
import com.example.resumeandroid.models.database.dao.CustomerDao
import com.example.resumeandroid.models.user.User
import com.example.resumeandroid.models.database.dao.UserDao
import com.example.resumeandroid.models.user.Customer

/**
 * Create app database using SQLite Database
 */
@Database(entities = [User::class, Customer::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun getCustomerDao(): CustomerDao

    companion object {
        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DatabaseString.NAME_DB)
                .build()
    }
}