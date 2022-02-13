package com.example.viewpagertest.model.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsApi {



    @GET(END_POINT)
    fun getSongs(
        @Query(TERM) term: String,
        @Query(MEDIA) media: String = "music",
        @Query(ENTITY) entity: String = "song",
        @Query(LIMIT) limit: Int = 50
    ): Call<SongResponse>

}