package com.example.viewpagertest.model.remote

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongResponse(val results: List<SongItem>) : Parcelable

@Parcelize
data class SongItem(val artistName: String,
                    val collectionName: String,
                    val artworkUrl60: String,
                    val trackPrice:Double,
                    val previewUrl:String):Parcelable