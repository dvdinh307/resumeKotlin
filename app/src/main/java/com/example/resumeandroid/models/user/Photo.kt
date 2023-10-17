package com.example.resumeandroid.models.user

import com.squareup.moshi.Json

data class Photo(
    val id: String,
    // used to map img_src from the JSON to imgSrcUrl in our class
    @Json(name = "img_src") val imgSrcUrl: String
)
