package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class TopTags(
    @SerializedName("@attr")
    val attr: Attr,
    val tag: List<Tag>
)