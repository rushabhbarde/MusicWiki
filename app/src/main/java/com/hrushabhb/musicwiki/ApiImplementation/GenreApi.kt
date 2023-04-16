package com.hrushabhb.musicwiki.ApiImplementation

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
import retrofit2.http.GET
import retrofit2.http.Query

//Application name	MusicWiki
//API key	360fae415dc04c757bb6965947aa5f5d
//Shared secret	bc4b32855c3f7495088bca7c6607a484
//Registered to	hrushabhbarde

interface GenreApi {

    @GET("/2.0")
    suspend fun getTopTags(
        @Query("method") method: String = "tag.getTopTags",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<Genre>

    @GET("/2.0")
    suspend fun getTagInfo(
        @Query("tag") tag: String,
        @Query("method") method: String = "tag.getInfo",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<GenreInfo>

    @GET("/2.0")
    suspend fun getTopAlbums(
        @Query("tag") tag: String,
        @Query("method") method: String = "tag.getTopAlbums",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<GenreAlbums>

    @GET("/2.0")
    suspend fun getTopArtists(
        @Query("tag") tag: String,
        @Query("method") method: String = "tag.getTopArtists",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<GenreArtists>

    @GET("/2.0")
    suspend fun getTopTracks(
        @Query("tag") tag: String,
        @Query("method") method: String = "tag.getTopTracks",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<GenreTracks>

    @GET("/2.0")
    suspend fun getAlbumInfo(
        @Query("artist") artist: String,
        @Query("album") album: String,
        @Query("method") method: String = "album.getInfo",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<AlbumInfo>

    @GET("/2.0")
    suspend fun getArtistInfo(
        @Query("artist") artist: String,
        @Query("method") method: String = "artist.getInfo",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<ArtistInfo>

    @GET("/2.0")
    suspend fun getArtistTopAlbums(
        @Query("artist") artist: String,
        @Query("method") method: String = "artist.getTopAlbums",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<ArtistTopAlbums>

    @GET("/2.0")
    suspend fun getArtistTopTracks(
        @Query("artist") artist: String,
        @Query("method") method: String = "artist.getTopTracks",
        @Query("api_key") apiKey: String = "360fae415dc04c757bb6965947aa5f5d",
        @Query("format") format: String = "json"
    ): Response<ArtistTopTracks>

}