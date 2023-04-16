package com.hrushabhb.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrushabhb.musicwiki.DataClasses.TagXX
import com.hrushabhb.musicwiki.GenreActivity
import com.hrushabhb.musicwiki.databinding.GenreItemBinding

class AlbumInfoGenreAdapter(var mContext: Context) : RecyclerView.Adapter<AlbumInfoGenreAdapter.AlbumInfoGenreViewHolder>() {

    inner class AlbumInfoGenreViewHolder(val binding: GenreItemBinding ) :
            RecyclerView.ViewHolder(binding.root)

    var AlbumInfoGenre: List<TagXX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumInfoGenreViewHolder {
        return AlbumInfoGenreViewHolder(
            GenreItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return AlbumInfoGenre.size
    }

    override fun onBindViewHolder(holder: AlbumInfoGenreViewHolder, position: Int) {
        holder.binding.apply {
            genreName.text = AlbumInfoGenre[position].name
        }
        holder.binding.root.setOnClickListener{
            val mIntent = Intent(mContext, GenreActivity::class.java)
            mIntent.putExtra("NAME", AlbumInfoGenre[position].name)
            mContext.startActivity(mIntent)
        }
    }


}