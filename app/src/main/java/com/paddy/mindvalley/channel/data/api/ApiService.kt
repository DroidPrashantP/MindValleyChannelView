package com.paddy.mindvalley.channel.data.api

import com.paddy.mindvalley.channel.data.model.SectionData
import retrofit2.http.GET

import retrofit2.http.POST

interface ApiService {

    @GET("raw/z5AExTtw")
    suspend fun getNewEpisode(): SectionData

    @GET("raw/Xt12uVhM")
    suspend fun getChannelData(): SectionData

    @GET("raw/A0CgArX3")
    suspend fun getCategoriesData(): SectionData
}