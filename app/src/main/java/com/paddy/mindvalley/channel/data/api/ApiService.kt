package com.paddy.mindvalley.channel.data.api

import com.paddy.mindvalley.channel.data.model.SectionData

import retrofit2.http.POST

interface ApiService {

    @POST("raw/z5AExTtw")
    suspend fun getNewEpisode(): SectionData

    @POST("raw/Xt12uVhM")
    suspend fun getChannelData(): SectionData

    @POST("raw/A0CgArX3")
    suspend fun getCategoriesData(): SectionData
}