package com.example.resumeandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumeandroid.models.network.AppApi
import com.example.resumeandroid.models.user.Photo
import kotlinx.coroutines.launch

enum class PhotoStatus { LOADING, ERROR, DONE }

class LoadImageModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<PhotoStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<PhotoStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _photos = MutableLiveData<List<Photo>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val photos: LiveData<List<Photo>> = _photos

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [Photo] [List] [LiveData].
     */
    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            _status.value = PhotoStatus.LOADING
            try {
                _photos.value = AppApi.retrofitService.getPhotos()
                _status.value = PhotoStatus.DONE
            } catch (e: Exception) {
                _status.value = PhotoStatus.ERROR
                _photos.value = listOf()
            }
        }
    }

}