package com.example.viewpagertest.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpagertest.databinding.DisplaySongsFragmentLayoutBinding
import com.example.viewpagertest.model.remote.SongItem
import com.example.viewpagertest.model.remote.SongResponse

const val SONG_ITEM: String = "Song"

class DisplaySongFragment(private val playSongEvent: (SongItem) -> Unit) : Fragment() {

    private lateinit var binding: DisplaySongsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplaySongsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun updateAdapter(dataSet: SongResponse) {
        binding?.let {
            binding.songListResults.layoutManager = GridLayoutManager(context, 1)
            binding.songListResults.adapter = SongsAdapter(dataSet) {
                playSongEvent(it)
            }
        }
    }
}