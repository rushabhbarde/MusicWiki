package com.hrushabhb.musicwiki.DataClasses

import com.google.gson.annotations.SerializedName

data class TopArtists(
    val artist: List<ArtistX>,
    @SerializedName("@attr")
    val attr: AttrXXXX
)