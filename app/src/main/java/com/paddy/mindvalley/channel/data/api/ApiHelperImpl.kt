package com.paddy.mindvalley.channel.data.api

import com.paddy.mindvalley.channel.data.model.SectionData

class ApiHelperImpl(var apiService: ApiService) : ApiHelper {
    override suspend fun getNewEpisode(): SectionData {
        return apiService.getNewEpisode()
    }

    override suspend fun getChannelData(): SectionData {
        return apiService.getChannelData()
    }

    override suspend fun getCategoriesData(): SectionData {
        return apiService.getCategoriesData()
    }
}