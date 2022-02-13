package com.example.viewpagertest.view

import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertest.R
import com.example.viewpagertest.databinding.ItemLayoutBinding
import com.example.viewpagertest.model.remote.SongItem
import com.example.viewpagertest.model.remote.SongResponse
import com.squareup.picasso.Picasso
import java.lang.StringBuilder

class SongsHolder (private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    fun onBind(songItem: SongItem, callback : (SongItem) -> Unit){
        binding.tvSongTitle.text = songItem.collectionName
        binding.tvSongArtist.text = songItem.artistName
        binding.tvSongPrice.text = binding.root.context.getString(R.string.price_format, songItem.trackPrice.toString())

        Picasso.get()
            .load(songItem.artworkUrl60)
            .into(binding.ivCover)

        binding.root.setOnClickListener{
            callback(songItem)
        }
    }
}