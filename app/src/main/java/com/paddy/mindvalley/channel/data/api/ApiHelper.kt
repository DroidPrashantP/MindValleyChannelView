package com.paddy.mindvalley.channel.data.api

import com.paddy.mindvalley.channel.data.model.SectionData

interface ApiHelper {

    suspend fun getNewEpisode(): SectionData

    suspend fun getChannelData(): SectionData

    suspend fun getCategoriesData(): SectionData
}