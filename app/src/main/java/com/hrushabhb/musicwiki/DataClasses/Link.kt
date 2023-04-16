package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class Link(
    val href: String,
    val rel: String,
    @SerializedName("#text")
    val text: String
)