package com.example.resumeandroid.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.resumeandroid.databinding.FragmentListImageBinding
import com.example.resumeandroid.viewmodels.LoadImageModel
import com.example.resumeandroid.views.adapter.PhotoGridAdapter

class ListImageFragment : Fragment() {
    private val viewModel: LoadImageModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListImageBinding =
            FragmentListImageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.photosGrid.adapter = PhotoGridAdapter()
        // Inflate the layout for this fragment
        return binding.root
    }

}