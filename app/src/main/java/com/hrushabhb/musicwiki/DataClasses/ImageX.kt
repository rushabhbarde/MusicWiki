package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class ImageX(
    val size: String,
    @SerializedName("#text")
    val text: String
)