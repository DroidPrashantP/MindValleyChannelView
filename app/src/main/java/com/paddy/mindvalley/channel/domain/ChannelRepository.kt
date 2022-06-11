package com.paddy.mindvalley.channel.domain

import com.paddy.mindvalley.channel.data.api.ApiHelper
import com.paddy.mindvalley.channel.data.model.SectionData

class ChannelRepository(var apiService: ApiHelper) {

    suspend fun getNewEpisode() : SectionData{
        return apiService.getNewEpisode()
    }

    suspend fun getChannelData() : SectionData{
        return apiService.getChannelData()
    }

    suspend fun getCategoriesData() : SectionData{
        return apiService.getCategoriesData()
    }
}