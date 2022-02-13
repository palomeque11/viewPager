package com.example.viewpagertest

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewpagertest.model.remote.SongItem
import com.example.viewpagertest.view.ViewPagerFragment
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_songs, ViewPagerFragment() {
                playAudio(it)
            }).commit()
    }

    private fun playAudio(song: SongItem) {

        try {
            if(mediaPlayer.isPlaying){
                mediaPlayer.reset();
            }

            mediaPlayer.setDataSource(song.previewUrl)
            mediaPlayer.prepare()
            mediaPlayer.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        // below line is use to display a toast message.
        Toast.makeText(this, "${song.collectionName} started playing..", Toast.LENGTH_SHORT).show()
    }
}
