package com.paddy.mindvalley.channel.ui

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.data.model.ChannelViewType
import com.paddy.mindvalley.channel.databinding.LayoutChannelPageTypeItemBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelSubSectionAdapter

class ChannelPageTypeAdapterViewHolder(var binding : LayoutChannelPageTypeItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, channelListItem: ChannelListItem?){
        channelListItem?.let {
            binding.tbChannelScreenNewEpisodeTitle.text = it.sectionTitle

            when (it.channelViewType) {
                ChannelViewType.NEW_EPISODE -> {
                    binding.rvChannelScreenMainList.apply {
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        adapter =  ChannelSubSectionAdapter(context, channelListItem)
                    }
                }
                ChannelViewType.CHANNEL_SECTION -> {
                    binding.rvChannelScreenMainList.apply {
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                        adapter =  ChannelSubSectionAdapter(context, channelListItem)
                    }
                }
                ChannelViewType.CATEGORY_SECTION -> {
                    binding.rvChannelScreenMainList.apply {
                        layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
                        adapter =  ChannelSubSectionAdapter(context, channelListItem)
                    }
                }
            }
        }

    }
}