package com.example.viewpagertest.viewmodel

import android.util.Log
import com.example.viewpagertest.model.common.Network
import com.example.viewpagertest.model.remote.CATEGORIES
import com.example.viewpagertest.model.remote.SongResponse
import retrofit2.Call

class SongsViewModel {

    fun getRockSongs(): Call<SongResponse> {
        return Network.songsApi.getSongs(CATEGORIES[0])
    }

    fun getClassicSongs(): Call<SongResponse> {
        return Network.songsApi.getSongs(CATEGORIES[1])
    }

    fun getPopSongs(): Call<SongResponse> {
        return Network.songsApi.getSongs(CATEGORIES[2])
    }
}