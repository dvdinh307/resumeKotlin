package com.example.resumeandroid.models.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.resumeandroid.models.user.Customer

@Dao
interface CustomerDao {
    @Query("SELECT * from CUSTOMER")
    fun getUser(): LiveData<List<Customer>>

    @Insert
    fun addCustomer(customer: Customer)
}