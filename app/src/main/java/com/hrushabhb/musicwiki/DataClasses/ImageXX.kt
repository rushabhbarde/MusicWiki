package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class ImageXX(
    val size: String,
    @SerializedName("#text")
    val text: String
)