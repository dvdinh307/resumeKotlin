package com.example.resumeandroid.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumeandroid.databinding.ItemCustomerBinding
import com.example.resumeandroid.models.user.Customer

class CustomerAdapter(val context: Context) :
    RecyclerView.Adapter<CustomerAdapter.NoteViewHolder>() {
    private var customers: List<Customer> = listOf()

    inner class NoteViewHolder(val binding: ItemCustomerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding =
            ItemCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = customers.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        with(holder) {
            with(customers[position]) {
                with(binding) {
                    tvName.text = name
                    tvAge.text = age.toString()
                    tvJob.text = jobs
                }
            }
        }
    }

    fun addALlCustomer(list: List<Customer>) {
        customers = list
    }
}