package com.paddy.mindvalley.channel.data.api

import com.paddy.mindvalley.channel.data.db.ChannelScreenSessionDAO
import com.paddy.mindvalley.channel.data.model.Data
import com.paddy.mindvalley.channel.data.model.SectionData
import com.paddy.mindvalley.channel.utils.NetworkUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiHelperImpl(private var apiService: ApiService,
                    private val networkHelper: NetworkUtils,
                    private var channelScreenSessionDAO: ChannelScreenSessionDAO) : ApiHelper {

    override suspend fun getNewEpisode(): SectionData {
        return if (networkHelper.isNetworkConnected()) {
            val newEpisodeData = apiService.getNewEpisode()

            // Store new episodes data in database
            withContext(Dispatchers.IO) {
                newEpisodeData.data.media?.let { episodes ->
                    channelScreenSessionDAO.insertMedia(episodes)
                }
            }
            newEpisodeData

        } else {
            // fetch new episodes list from database
            SectionData(Data(channelScreenSessionDAO.getAllMediaItems(), null, null))
        }
    }

    override suspend fun getChannelData(): SectionData {
        return if (networkHelper.isNetworkConnected()) {
            val channelData = apiService.getChannelData()

            // Store new Channel data in database
            withContext(Dispatchers.IO) {
                channelData.data.channels?.let { channelsList ->
                    channelScreenSessionDAO.insertChannel(channelsList)
                }
            }
            channelData
        } else {
            // fetch channel list from database
            SectionData(Data(null, channelScreenSessionDAO.getAllChannelItems(), null))
        }
    }

    override suspend fun getCategoriesData(): SectionData {
        return if (networkHelper.isNetworkConnected()) {
            val categoriesData = apiService.getCategoriesData()

            // Store new Channel data in database
            withContext(Dispatchers.IO) {
                categoriesData.data.categories?.let { categoriesList ->
                    channelScreenSessionDAO.insertCategory(categoriesList)
                }
            }
            categoriesData

        } else {
            // fetch categories list from database
            SectionData(Data(null, null, channelScreenSessionDAO.getAllCategoryItems()))
        }
    }
}