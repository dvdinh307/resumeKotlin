package com.example.resumeandroid.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.resumeandroid.R
import com.example.resumeandroid.databinding.FragmentAddCustomerBinding
import com.example.resumeandroid.models.bases.getValues
import com.example.resumeandroid.models.user.Customer
import com.example.resumeandroid.viewmodels.CustomerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCustomerFragment : Fragment() {

    private var _binding: FragmentAddCustomerBinding? = null
    private val customerViewModel: CustomerViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCustomerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            btnClose.setOnClickListener {
                findNavController().navigate(R.id.backToList)
            }

            btnAdd.setOnClickListener {
                val name = edtName.getValues()
                val age = edtAge.getValues().toInt()
                val jobs = edtJob.getValues()
                customerViewModel.addCustomer(Customer(name, age, jobs))
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}