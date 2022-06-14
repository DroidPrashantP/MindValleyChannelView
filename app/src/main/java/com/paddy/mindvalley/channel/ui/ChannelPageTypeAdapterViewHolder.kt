package com.paddy.mindvalley.channel.ui

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paddy.mindvalley.channel.data.model.ChannelListItem
import com.paddy.mindvalley.channel.data.model.ChannelViewType
import com.paddy.mindvalley.channel.databinding.LayoutChannelSectionTypeItemBinding
import com.paddy.mindvalley.channel.ui.adapter.ChannelSubSectionAdapter
import com.paddy.mindvalley.channel.utils.gone
import com.paddy.mindvalley.channel.utils.show

class ChannelPageTypeAdapterViewHolder(var binding: LayoutChannelSectionTypeItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(context: Context?, channelListItem: ChannelListItem?) {
        channelListItem?.let {
            if(it.sectionTitle.isNullOrBlank()){
                binding.tbChannelScreenNewEpisodeTitle.gone()
            } else {
                binding.tbChannelScreenNewEpisodeTitle.show()
                binding.tbChannelScreenNewEpisodeTitle.text = it.sectionTitle
            }


            val llm = when (it.channelViewType) {
                    ChannelViewType.NEW_EPISODE -> {
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    }
                    ChannelViewType.CHANNEL_SECTION -> {
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

                    }
                    ChannelViewType.CATEGORY_SECTION -> {
                        GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
                    }
                }

            binding.rvChannelScreenMainList.apply {
                layoutManager = llm
                adapter = ChannelSubSectionAdapter(context, channelListItem)
            }
        }

    }
}