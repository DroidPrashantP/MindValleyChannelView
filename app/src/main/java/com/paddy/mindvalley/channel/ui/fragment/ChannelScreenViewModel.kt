package com.paddy.mindvalley.channel.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.data.model.ChannelViewType
import com.paddy.mindvalley.channel.domain.ChannelRepository
import com.paddy.mindvalley.channel.utils.AppConstant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import timber.log.Timber


class ChannelScreenViewModel constructor(private val channelRepository: ChannelRepository) : ViewModel() {

     fun fetchChannelScreenData() = liveData {

         // coroutineScope block will wait here until all child tasks are completed
         withContext(viewModelScope.coroutineContext) {
             val list = mutableListOf<ChannelListItem>()
             withContext(Dispatchers.IO) {
                 coroutineScope {
                     // this will allow us to run multiple tasks in parallel
                     withContext(Dispatchers.Default) { // this will allow us to run multiple tasks in parallel
                             channelRepository.getNewEpisode().let {
                                 val item = ChannelListItem(AppConstant.NEW_EPISODE, ChannelViewType.NEW_EPISODE, it)
                                 list.add(item)
                             }
                             channelRepository.getChannelData().let {
                                 val item = ChannelListItem(AppConstant.EMPTY, ChannelViewType.CHANNEL_SECTION, it)
                                 list.add(item)
                             }
                             channelRepository.getCategoriesData().let {
                                 val item = ChannelListItem(AppConstant.BROWSE_BY_CATEGORIES, ChannelViewType.CATEGORY_SECTION, it)
                                 list.add(item)
                             }
                     }
                 }  // coroutineScope block will wait here until all child tasks are completed

                 emit(list)
             }
         }
     }

}