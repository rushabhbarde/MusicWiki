package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class Image(
    val size: String,
    @SerializedName("#text")
    val text: String
)