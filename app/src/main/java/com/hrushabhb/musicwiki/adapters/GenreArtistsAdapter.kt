package com.hrushabhb.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrushabhb.musicwiki.ArtistActivity
import com.hrushabhb.musicwiki.DataClasses.ArtistX
import com.hrushabhb.musicwiki.databinding.CardItemBinding
import com.hrushabhb.musicwiki.loadImage

class GenreArtistsAdapter(var mContext: Context) :
    RecyclerView.Adapter<GenreArtistsAdapter.GenreArtistsViewHolder>() {
    inner class GenreArtistsViewHolder(val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var genreArtists: List<ArtistX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        return GenreArtistsViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = genreArtists[position].name
            itemImg.loadImage(genreArtists[position].image[0].text)
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, ArtistActivity::class.java)
            mIntent.putExtra("AR-NAME", genreArtists[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
        return genreArtists.size
    }
}