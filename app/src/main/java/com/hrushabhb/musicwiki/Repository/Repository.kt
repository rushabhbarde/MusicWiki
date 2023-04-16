package com.hrushabhb.musicwiki.Repository

import com.hrushabhb.musicwiki.ApiImplementation.RetrofitInstance
import com.hrushabhb.musicwiki.DataClasses.AlbumInfo
import com.hrushabhb.musicwiki.DataClasses.ArtistInfo
import com.hrushabhb.musicwiki.DataClasses.ArtistTopAlbums
import com.hrushabhb.musicwiki.DataClasses.ArtistTopTracks
import com.hrushabhb.musicwiki.DataClasses.Genre
import com.hrushabhb.musicwiki.DataClasses.GenreAlbums
import com.hrushabhb.musicwiki.DataClasses.GenreArtists
import com.hrushabhb.musicwiki.DataClasses.GenreInfo
import com.hrushabhb.musicwiki.DataClasses.GenreTracks
import retrofit2.Response

class Repository {
    suspend fun getTopTags(): Response<Genre> {
        return RetrofitInstance.api.getTopTags()
    }

    suspend fun getTagInfo(tag: String): Response<GenreInfo> {
        return RetrofitInstance.api.getTagInfo(tag)
    }

    suspend fun getTagAlbum(tag: String): Response<GenreAlbums> {
        return RetrofitInstance.api.getTopAlbums(tag)
    }

    suspend fun getTagArtist(tag: String): Response<GenreArtists> {
        return RetrofitInstance.api.getTopArtists(tag)
    }

    suspend fun getTagTracks(tag: String): Response<GenreTracks> {
        return RetrofitInstance.api.getTopTracks(tag)
    }

    suspend fun getAlbumInfo(artist: String, album: String): Response<AlbumInfo> {
        return RetrofitInstance.api.getAlbumInfo(artist, album)
    }

    suspend fun getArtistInfo(artist: String): Response<ArtistInfo> {
        return RetrofitInstance.api.getArtistInfo(artist)
    }

    suspend fun getArtistTopAlbums(artist: String): Response<ArtistTopAlbums> {
        return RetrofitInstance.api.getArtistTopAlbums(artist)
    }

    suspend fun getArtistTopTracks(artist: String): Response<ArtistTopTracks> {
        return RetrofitInstance.api.getArtistTopTracks(artist)
    }
}