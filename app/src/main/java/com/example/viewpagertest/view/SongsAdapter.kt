package com.example.viewpagertest.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.viewpagertest.databinding.ItemLayoutBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertest.model.remote.SongItem
import com.example.viewpagertest.model.remote.SongResponse

class SongsAdapter(
    private val dataSet: SongResponse,
    private val playSongEvent: (SongItem) -> Unit
) : RecyclerView.Adapter<SongsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SongsHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: SongsHolder, position: Int) {
        holder.onBind(dataSet.results[position]) {
            playSongEvent(it)
        }
    }




    override fun getItemCount(): Int = dataSet.results.size

}