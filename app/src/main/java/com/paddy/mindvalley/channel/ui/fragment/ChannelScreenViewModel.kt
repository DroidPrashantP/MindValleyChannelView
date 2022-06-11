package com.paddy.mindvalley.channel.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.paddy.mindvalley.channel.domain.ChannelRepository
import com.paddy.mindvalley.channel.utils.NetworkUtils
import kotlinx.coroutines.launch
import timber.log.Timber


class ChannelScreenViewModel constructor(private val channelRepository: ChannelRepository,
                              private val networkHelper: NetworkUtils) : ViewModel() {

     fun fetchChannelScreenData() = liveData {
        viewModelScope.launch {
            if (networkHelper.isNetworkConnected()) {
                channelRepository.getNewEpisode().let {
                    Timber.e(Gson().toJson(it))
                    emit(it)
                }
                channelRepository.getChannelData().let {
                    Timber.e(Gson().toJson(it))
                    emit(it)
                }
                channelRepository.getCategoriesData().let {
                    Timber.e(Gson().toJson(it))
                    emit(it)
                }
            } else {

            }
        }
    }

}