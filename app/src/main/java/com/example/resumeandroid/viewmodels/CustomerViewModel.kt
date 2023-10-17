package com.example.resumeandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumeandroid.models.database.repository.CustomerRepository
import com.example.resumeandroid.models.user.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(private val customerRepository: CustomerRepository) :
    ViewModel() {
    fun getAllCustomer(): LiveData<List<Customer>> = customerRepository.getAllCustomer()

    fun addCustomer(customer: Customer) = viewModelScope.launch(Dispatchers.IO) {
        customerRepository.addCustomer(customer)
    }

}