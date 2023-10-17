package com.example.resumeandroid.models.database.repository

import androidx.lifecycle.LiveData
import com.example.resumeandroid.models.appinterface.CustomerInterface
import com.example.resumeandroid.models.database.dao.CustomerDao
import com.example.resumeandroid.models.user.Customer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomerRepository @Inject constructor(private val customerDao: CustomerDao) :
    CustomerInterface {
    override fun getAllCustomer(): LiveData<List<Customer>> = customerDao.getUser()

    override fun addCustomer(customer: Customer) = customerDao.addCustomer(customer)
}