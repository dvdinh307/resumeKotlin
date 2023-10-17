package com.example.resumeandroid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resumeandroid.R
import com.example.resumeandroid.databinding.FragmentListCustomerBinding
import com.example.resumeandroid.viewmodels.CustomerViewModel
import com.example.resumeandroid.views.adapter.CustomerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCustomerFragment : Fragment(R.layout.fragment_list_customer) {
    private lateinit var adapterCus: CustomerAdapter
    private val viewModel: CustomerViewModel by viewModels()
    private lateinit var binding: FragmentListCustomerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterCus = CustomerAdapter(requireContext())
        with(binding) {
            listMain.adapter = adapterCus
            listMain.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(requireContext())
                setOnClickListener {  }
            }
            btnAddCustomer.setOnClickListener {
                findNavController().navigate(R.id.actionAddCustomer)
            }
        }
        viewModel.getAllCustomer().observe(viewLifecycleOwner) {
            adapterCus.addALlCustomer(it)
        }
    }


}