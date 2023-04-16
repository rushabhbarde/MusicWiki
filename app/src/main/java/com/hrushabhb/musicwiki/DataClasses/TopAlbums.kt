package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class TopAlbums(
    val album: List<AlbumXX>,
    @SerializedName("@attr")
    val attr: AttrXXXXXXXXXX
)