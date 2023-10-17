package com.example.resumeandroid.models.di

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.resumeandroid.R
import com.example.resumeandroid.models.user.Photo
import com.example.resumeandroid.viewmodels.PhotoStatus
import com.example.resumeandroid.views.adapter.PhotoGridAdapter

@BindingAdapter("imageUrl")
fun bindImage(imv: ImageView, url: String) {
    val imgUri = url.toUri().buildUpon().scheme("https").build()
    imv.load(imgUri) {
        placeholder(R.drawable.loading_animation)
        error(R.drawable.ic_broken_image)
    }
}

@BindingAdapter("listData")
fun bindList(rcy: RecyclerView, list: List<Photo>?) {
    val adapter = rcy.adapter as PhotoGridAdapter
    adapter.submitList(list)
}

@BindingAdapter("photosApiStatus")
fun bindAPIStatus(imv: ImageView, status: PhotoStatus) {
    when (status) {
        PhotoStatus.LOADING -> {
            imv.visibility = View.VISIBLE
            imv.setImageResource(R.drawable.loading_animation)
        }

        PhotoStatus.DONE -> {
            imv.visibility = View.GONE
        }

        PhotoStatus.ERROR -> {
            imv.visibility = View.VISIBLE
            imv.setImageResource(R.drawable.ic_connection_error)
        }
    }
}


