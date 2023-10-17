package com.example.resumeandroid.models.appinterface

import androidx.lifecycle.LiveData
import com.example.resumeandroid.models.user.Customer

interface CustomerInterface {
    fun getAllCustomer(): LiveData<List<Customer>>
    fun addCustomer(customer: Customer)
}