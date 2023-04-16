package com.hrushabhb.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrushabhb.musicwiki.AlbumActivity
import com.hrushabhb.musicwiki.DataClasses.Album
import com.hrushabhb.musicwiki.databinding.CardItemBinding
import com.hrushabhb.musicwiki.loadImage

class GenreAlbumsAdapter(var mContext: Context) :
    RecyclerView.Adapter<GenreAlbumsAdapter.GenreAlbumsViewHolder>() {
    inner class GenreAlbumsViewHolder(val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var genreAlbums: List<Album> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAlbumsViewHolder {
        return GenreAlbumsViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreAlbumsViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = genreAlbums[position].name
            itemArtistName.text = genreAlbums[position].artist.name
            itemImg.loadImage(genreAlbums[position].image[0].text)
        }

        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, AlbumActivity::class.java)
            mIntent.putExtra("ANAME", genreAlbums[position].name)
            mIntent.putExtra("ARNAME", genreAlbums[position].artist.name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return genreAlbums.size
    }


}